package com.chengchengtech.common.sms;

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
public interface SMSResult {

    /**
     * 是否成功
     * @return boolean
     */
    boolean isOk();

    /**
     * 返回异常信息
     *
     * @return errorMessage
     */
    String errorMessage();


    /**
     * 返回异常代码
     *
     * @return errorCode
     */
    String errorCode();
}
