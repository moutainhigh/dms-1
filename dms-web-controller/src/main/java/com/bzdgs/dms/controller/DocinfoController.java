package com.bzdgs.dms.controller;

/*import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;*/

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.DocinfoQuery;
import com.bzdgs.dms.service.IDocinfoService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Description 档案信息DocinfoController
 * @author 刘琪
 * @since
 */

@RestController
public class DocinfoController {

    @Autowired
    private IDocinfoService docinfoService;

    @PostMapping("/docinfo/page")
    public PageList<Docinfo> selectIDType(@RequestBody DocinfoQuery docinfoQuery){
        return docinfoService.page(docinfoQuery);
    }
    @PostMapping("/docinfo/expired")
    public PageList<Docinfo> selectForExpired(@RequestBody DocinfoQuery docinfoQuery){
        return docinfoService.selectForExpired(docinfoQuery);

    }

    @PostMapping("/docinfo/docSn")
    public PageList<Docinfo> selectByDocsn(@RequestBody DocinfoQuery docinfoQuery){
        return docinfoService.selectByDocsn(docinfoQuery);
    }


    @GetMapping("/docinfo/list")
    public List<Docinfo> list(){
        return docinfoService.list();
    }

    @GetMapping("/docinfo/docs")
    public List<Docinfo> docs(){
        return docinfoService.docs();
    }

    @GetMapping("/docinfo/missed")
    public List<Docinfo> missed(){
        return docinfoService.missed();
    }

    @DeleteMapping("/docinfo/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){

        try {
            docinfoService.deleteById(id);
            return AjaxResult.me().setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("删除失败");

    }

    @PostMapping("/docinfo")
    public AjaxResult save(@RequestBody Docinfo docinfo){
        try {
            if(docinfo.getId()!=null){
                System.out.println("修改");
                //docinfoService.updateById(docinfo);
            }else{
                docinfoService.insert(docinfo);
            }
            return AjaxResult.me().setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("保存失败");

    }

   /* @GetMapping("/docinfo/export")
    public String export(ModelMap map, DocinfoQuery docinfoQuery){
        List<Docinfo> list = docinfoService.selectAllByQuery(docinfoQuery);
        list.forEach(docinfo -> System.out.println(docinfo));
        ExportParams params = new ExportParams("档案列表", "测试第一次", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, list); // 数据集合
        map.put(NormalExcelConstants.CLASS, Docinfo.class);//导出实体
        map.put(NormalExcelConstants.PARAMS, params);//参数
        map.put(NormalExcelConstants.FILE_NAME, "档案列表");//文件名称
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;//View名称
    }*/

    @PostMapping("/docinfo/upload")
    public AjaxResult upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file){
        //拿到文件名
        String originalFilename = file.getOriginalFilename();
        //截取文件名的后缀
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成文件名是随机数uuid+后缀名
        String filename = UUID.randomUUID().toString()+ ext;
        //设置路径
        String path="E:/IdeaWorkSpace/manage/crm/crm-web/src/main/webapp/imgs";
        //String path = request.getServletContext().getRealPath("imgs");
        path += "/"+filename;
        path = path.replace("\\", "/");
        File file1 = new File(path);
        try {
            file.transferTo(file1);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return AjaxResult.me().setMsg("保存成功");
    }

   /* @PostMapping("/docinfo/upload")
    public AjaxResult save(@RequestParam("multipartfiles") MultipartFile[] multipartfiles,String productId) throws IOException {
        //获取项目编译之后的文件路径，一般是“项目路径/target/classes”
        String Path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")+"static/swagger/")).replaceAll("file:/", "").replaceAll("%20", " ").trim();
        if(Path.indexOf(":") != 1){
            Path = File.separator + Path;
        }
        //遍历文件
        if(multipartfiles != null && multipartfiles.length>0){
            for(MultipartFile item : multipartfiles){
                String fileName = item.getOriginalFilename();//获取文件名
                String filePath = Path + "uploadFiles/uploadFiles";//自定义上传路径
                File file = new File(filePath,fileName);
                if(!file.exists()){//判断文件夹是否存在，如果不存在则创建
                    if(!file.getParentFile().exists()){
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                item.transferTo(file);//上传文件
            }
        }

        return AjaxResult.me().setMsg("保存成功");
    }*/


}
