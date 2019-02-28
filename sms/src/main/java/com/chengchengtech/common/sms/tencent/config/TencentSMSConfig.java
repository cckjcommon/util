package com.chengchengtech.common.sms.tencent.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 下午5:21
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
@Data
@Configuration
public class TencentSMSConfig {

    /**
     * 短信助老端SDK
     * Appid 1400095883，
     * AppKey 2cf80f7a812e4e570456b52a5ae7095e
     * 亲属端SDK
     * Appid 1400094158，
     * AppKey  a9e511b85b6b65f6abba6f382e7ae6bc
     */
    private int APPID = 1400095883;

    private String APPKEY = "2cf80f7a812e4e570456b52a5ae7095e";

    private String APPDESC = "";

    public static final String NATIONCODE = "86";

    private String SIGN = "";

    private int verifyTemplateID = 127537;

}
