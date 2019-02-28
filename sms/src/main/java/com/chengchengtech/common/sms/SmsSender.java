package com.chengchengtech.common.sms;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 上午10:04
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public interface SmsSender {

    /**
     * 发送验证码
     *
     * @param mobile
     * @param verifyCode
     * @return 发送结果
     */
    SMSResult sendVerifyCode(String mobile, String verifyCode);


    SMSResult sendSmsByTemplateId(String mobile, Integer smsTemplateId, ArrayList<String> params);

}
