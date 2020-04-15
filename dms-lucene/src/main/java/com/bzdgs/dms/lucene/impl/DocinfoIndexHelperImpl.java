package com.bzdgs.dms.lucene.impl;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.domain.Doctype;
import com.bzdgs.dms.lucene.IDocinfoIndexHelper;
import com.bzdgs.dms.query.DocinfoQuery;
import com.bzdgs.dms.util.LuceneUtil;
import com.bzdgs.dms.util.PageList;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 20:18 2019/12/14
 * @Version : v1.0
 */
@Component
public class DocinfoIndexHelperImpl implements IDocinfoIndexHelper {

    private static final String tableName = "DOCINFO";

    /**
     * 更新索引
     * @param docs
     */
    @Override
    public void updateIndex(List<Docinfo> docs) {
        IndexWriter indexWriter = null;
        try {
            // 保存路径
            Directory directory = FSDirectory.open(Paths.get(LuceneUtil.INSTANCE.getIndexParent()+tableName));

            // 配置对象
            Analyzer analyzer = new IKAnalyzer(false);
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

            // 核心对象
            indexWriter = new IndexWriter(directory,indexWriterConfig);
            indexWriter.deleteAll(); // 删除 再添加 即更新

            // 给核心对象添加 document对象
            for (Docinfo doc : docs) {
                indexWriter.addDocument(docToDocument(doc));
            }
            indexWriter.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (indexWriter != null) {
                try {
                    indexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 把传入的doc对象 转为Lucene的 document对象
     * @param doc
     * @return
     */
    private Document docToDocument(Docinfo doc) {
        // 档案id  档案名称  档案编号   档案分类   档案日期  状态
        Document document = new Document();
        if(doc.getId() != null){
            document.add(new LongField("id",doc.getId(), Field.Store.YES));
        }
        if(!StringUtils.isEmpty(doc.getDocTitle())){
            document.add(new TextField("docTitle",doc.getDocTitle(), Field.Store.YES));
        }
        if(!StringUtils.isEmpty(doc.getDocSn())){
            document.add(new StringField("docSn",doc.getDocSn(), Field.Store.YES));
        }
        if(doc.getDocType_id() != null){
            document.add(new LongField("docType_id",doc.getDocType_id(), Field.Store.YES));
        }
        if(doc.getDoctype() != null &&!StringUtils.isEmpty(doc.getDoctype().getName())){
            document.add(new StringField("docType_name",doc.getDoctype().getName(), Field.Store.YES));
        }
        if(doc.getCreateDate() != null){
            document.add(new StringField("createDate",doc.getCreateDate().toString(), Field.Store.YES));
        }
        if(doc.getStatus() != null){
            document.add(new LongField("status",doc.getStatus(), Field.Store.YES));
        }
        return document;
    }

    /**
     * 查询索引
     * @param query
     */
    @Override
    public PageList<Docinfo> searchIndex(DocinfoQuery query) {
        DirectoryReader reader = null;
        try {
            Directory directory = FSDirectory.open(Paths.get(LuceneUtil.INSTANCE.getIndexParent() + tableName));
            reader = DirectoryReader.open(directory);
            // 查询的核心对象
            IndexSearcher indexSearcher = new IndexSearcher(reader);

            //  拼接查询条件
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            // 根据 档案名称查找
            if(!StringUtils.isEmpty(query.getKeyword())){
                BooleanQuery.Builder keywordQueryBuilder = new BooleanQuery.Builder();
                Analyzer analyzer = new IKAnalyzer(false);
                QueryParser queryParser = new QueryParser("docTitle",analyzer);
                keywordQueryBuilder.add(queryParser.parse("docTitle:"+query.getKeyword()), BooleanClause.Occur.MUST);
                builder.add(keywordQueryBuilder.build(), BooleanClause.Occur.MUST);
            }
            // 根据档案类型查找
            if(query.getDoctypeId() != null ){
                builder.add(new TermQuery(new Term("docType_id",query.getDoctypeId().toString())), BooleanClause.Occur.MUST);
            }
//            if(query.getBeginTime()!=null || query.getEndTime() != null){
//                builder.add(new TermQuery(new Term("createDate",query.getBeginTime().toString())), BooleanClause.Occur.MUST);
//                Term begin = new Term("createDate", query.getBeginTime().toString());
//                Term end = new Term("createDate", query.getEndTime().toString());
//
//                new NumericRangeQuery<Long>("createDate",1,query.getBeginTime(),query.getEndTime(),true,true);
//
//            }
            if(query.getStatus() != null){
                builder.add(new TermQuery(new Term("status",query.getStatus().toString())), BooleanClause.Occur.MUST);
            }

            builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
            /*
                查询 +  分页
             */
            TopDocs topDocs = indexSearcher.search(builder.build(), query.getPageNum()*query.getPageSize());  // 返回查询到的前100数据
            int total = topDocs.totalHits; // 得到查询出来的总数

            int start = (query.getPageNum()-1)*query.getPageSize(); // 页面起始条
            int end = query.getPageNum()*query.getPageSize(); // 页面结束条
            // 使 查询出来的总条数等于 页面总条数
            if(end >= total){end = total;}

            List<Docinfo> docs = new ArrayList<>();

            ScoreDoc[] scoreDocs = topDocs.scoreDocs;  // 获取到 doc的得分对象
            for(int i = start;i<end;i++){
                int docId = scoreDocs[i].doc; // 获取索引库中的docID
                Document doc = indexSearcher.doc(docId);
                // DOCUMENT对象 转为 docinfo对象
                docs.add(docToDocinfo(doc));
            }
            return new PageList<>(Long.valueOf(end),docs);

        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Docinfo docToDocinfo(Document doc) {
        Docinfo docinfo = new Docinfo();
        // 档案id  档案名称  档案编号   档案分类   档案日期  状态
        if(!StringUtils.isEmpty(doc.get("id"))){
            docinfo.setId(Long.valueOf(doc.get("id")));
        }
        if(!StringUtils.isEmpty(doc.get("docTitle"))){
            docinfo.setDocTitle(doc.get("docTitle"));
        }
        if(!StringUtils.isEmpty(doc.get("docSn"))){
            docinfo.setDocSn(doc.get("docSn"));
        }
        if(doc.get("docType_id")!=null){
            docinfo.setDocType_id(Long.valueOf(doc.get("docType_id")));
        }
        if(!StringUtils.isEmpty(doc.get("docType_name"))){
            Doctype doctype = new Doctype();
            doctype.setName(doc.get("docType_name"));
            docinfo.setDoctype(doctype);
        }
        if(!StringUtils.isEmpty(doc.get("createDate"))){
            docinfo.setCreateDate(new Date(doc.get("createDate")));
        }
        if(doc.get("status")!=null){
            docinfo.setStatus(Integer.valueOf(doc.get("status")));
        }
        return docinfo;
    }
}
