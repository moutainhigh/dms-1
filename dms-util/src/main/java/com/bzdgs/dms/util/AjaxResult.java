package com.bzdgs.dms.util;

import lombok.Getter;


/**
 *@Description AjaxResult
 * @Author liuqi
 * @param
 */
@Getter
public class AjaxResult {
    private boolean success = true;
    private String msg ="操作成功！";
    private Object resobj;

    private AjaxResult(){};

    public static AjaxResult me(){
        return new AjaxResult();
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;

        return this;
    }

    public AjaxResult setResobj(Object resobj) {
        this.resobj = resobj;
        return this;
    }
}


