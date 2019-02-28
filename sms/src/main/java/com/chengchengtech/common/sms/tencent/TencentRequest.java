package com.chengchengtech.common.sms.tencent;

import com.chengchengtech.common.sms.SMSRequest;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 下午5:20
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class TencentRequest implements SMSRequest {


    @Override
    public String getContent() {
        return null;
    }

    @Override
    public String getMobile() {
        return null;
    }

    @Override
    public int getTemplateId() {
        return 0;
    }

    @Override
    public ArrayList getTemplateParams() {
        return null;
    }
}
