package com.chengchengtech.util.verify;

import lombok.Data;

@Data
public class CheckResult {

    /**
     * 是否校验通过
     */
    private boolean isPass = false;
    /**
     * 参数位置，0表示整体，-1表示没有
     */
    private int objPos;

    /**
     * 异常信息
     */
    private String msg;

    public CheckResult(boolean result, int objPos) {
        this.isPass = result;
        this.objPos = objPos;
    }

    public CheckResult(boolean result, int objPos, String msg) {
        this.isPass = result;
        this.objPos = objPos;
        this.msg = msg;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public int getObjPos() {
        return objPos;
    }

    public void setObjPos(int objPos) {
        this.objPos = objPos;
    }

}