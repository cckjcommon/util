package com.chengchengtech.common.msg;

import com.chengchengtech.common.msg.gexin.NotificationPushReq;
import com.chengchengtech.common.msg.gexin.PushMessageRequest;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 上午10:58
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public interface MSGPusher {
    /**
     * 推送自定义消息
     *
     * @return
     */
    boolean pushMessage(PushMessageRequest req);

    /**
     * 推送通知消息
     *
     * @param req
     * @return
     */
    boolean pushNotification(NotificationPushReq req);

    /**
     * 绑定别名
     *
     * @param mobile
     * @param cid
     * @return
     */
    boolean bindAlias(String mobile, String cid);

}
