package com.chengchengtech.util.verify;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/5/19
 * Time: 下午10:27
 * Org : 思笛恩
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class VerifyCodePicResult {
    byte[] imageData;
    String code;

    public VerifyCodePicResult(byte[] imageData, String code) {
        this.imageData = imageData;
        this.code = code;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
