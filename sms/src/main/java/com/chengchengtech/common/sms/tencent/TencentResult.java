package com.chengchengtech.common.sms.tencent;

import com.chengchengtech.common.sms.SMSResult;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Author=Tao.Wang
 * Date=2018/2/26
 * Time=下午5:48
 * Org =承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author=Tao.Wang
 */
@Data
public class TencentResult implements SMSResult {

    private int result = -1;
    private String errmsg = "no return";
    private String ext = "";
    private int fee = 1;
    private String sid = "";

    @Override
    public boolean isOk() {
        return result == 0;
    }

    @Override
    public String errorMessage() {
        return errmsg;
    }

    @Override
    public String errorCode() {
        return String.valueOf(result);
    }
}
