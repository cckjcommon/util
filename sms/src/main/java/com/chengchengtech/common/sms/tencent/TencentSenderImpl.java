package com.chengchengtech.common.sms.tencent;

import com.chengchengtech.common.sms.SMSResult;
import com.chengchengtech.common.sms.SmsSender;
import com.chengchengtech.common.sms.tencent.config.TencentSMSConfig;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
@Service
public class TencentSenderImpl implements SmsSender {

    private final TencentSMSConfig config;

    private final SmsSingleSender singleSender;

    /**
     * 验证码过期时间，单位：分钟
     */
    private final static String verifyCodeExpiredTime = "2";

    @Autowired
    public TencentSenderImpl(TencentSMSConfig config) {
        this.config = config;
        this.singleSender = new SmsSingleSender(config.getAPPID(), config.getAPPKEY());
    }


    @Override
    public SMSResult sendVerifyCode(String mobile, String verifyCode) {
        TencentResult tencentResult = new TencentResult();
        try {

            ArrayList<String> params = new ArrayList<>();
            params.add(verifyCode);
            params.add(verifyCodeExpiredTime);
            SmsSingleSenderResult smsSingleSenderResult = this.singleSender.sendWithParam(TencentSMSConfig.NATIONCODE, mobile, config.getVerifyTemplateID(), params, config.getSIGN(), "", "");
            tencentResult.setErrmsg(smsSingleSenderResult.errMsg);
            tencentResult.setErrmsg(smsSingleSenderResult.ext);
            tencentResult.setFee(smsSingleSenderResult.fee);
            tencentResult.setResult(smsSingleSenderResult.result);
            tencentResult.setSid(smsSingleSenderResult.sid);
        } catch (HTTPException | IOException e) {
            e.printStackTrace();
        }

        return tencentResult;
    }

    @Override
    public SMSResult sendSmsByTemplateId(String mobile, Integer smsTemplateId, ArrayList<String> params) {
        TencentResult tencentResult = new TencentResult();
        try {
            SmsSingleSenderResult smsSingleSenderResult = this.singleSender.sendWithParam(TencentSMSConfig.NATIONCODE, mobile, smsTemplateId, params, config.getSIGN(), "", "");
            tencentResult.setErrmsg(smsSingleSenderResult.errMsg);
            tencentResult.setErrmsg(smsSingleSenderResult.ext);
            tencentResult.setFee(smsSingleSenderResult.fee);
            tencentResult.setResult(smsSingleSenderResult.result);
            tencentResult.setSid(smsSingleSenderResult.sid);
        } catch (HTTPException | IOException e) {
            e.printStackTrace();
        }

        return tencentResult;
    }
}
