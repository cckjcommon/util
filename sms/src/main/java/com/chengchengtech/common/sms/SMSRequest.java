package com.chengchengtech.common.sms;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 上午10:55
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public interface SMSRequest {

    /**
     * 短信内容
     *
     * @return 短信内容
     */
    String getContent();

    /**
     * 短信内容
     *
     * @return 短信内容
     */
    String getMobile();

    /**
     * 短信内容
     *
     * @return 短信内容
     */
    int getTemplateId();

    /**
     * 短信内容
     *
     * @return 短信内容
     */
    ArrayList getTemplateParams();
}
