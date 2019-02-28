package com.chengchengtech.common.msg.gexin;

import com.chengchengtech.common.msg.MSGPusher;
import com.gexin.rp.sdk.base.IAliasResult;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 下午12:07
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class GeXinPushImpl implements MSGPusher {

    private static IGtPush iGtPush = new IGtPush(PushConstant.host, PushConstant.appKey, PushConstant.masterSecret);


    public boolean pushMessage(PushMessageRequest req) {
        return pushMessageAndrid(req) && pushMessageIos(req);
    }

    public boolean pushNotification(NotificationPushReq req) {
        return pushNotificationAll(req);
    }


    public boolean bindAlias(String mobile, String cid) {
        IAliasResult iAliasResult = iGtPush.bindAlias(PushConstant.appId, cid, mobile);
        return iAliasResult.getResult();
    }

    /**
     * 推送消息到 Andorid 设备
     */
    private boolean pushMessageAndrid(PushMessageRequest req) {
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(TemplateFactory.androidtTemplate(req.getContent()));
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        IPushResult iPushResult = iGtPush.pushMessageToSingle(message, setTage(req.getMobile()));
        System.out.println(iPushResult);
        return true;
    }

    /**
     * 推送消息到ios 设备
     */
    private boolean pushMessageIos(PushMessageRequest req) {
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(TemplateFactory.iosTemplate(req.getContent()));
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        IPushResult iPushResult = iGtPush.pushMessageToSingle(message, setTage(req.getMobile()));
        System.out.println(iPushResult);
        return true;
    }

    /**
     * 推送通知消息
     */
    private boolean pushNotificationAll(NotificationPushReq req) {
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(TemplateFactory.notificationTemplate(req));
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        IPushResult iPushResult = iGtPush.pushMessageToSingle(message, setTage(req.getMobile()));
        return true;
    }

    /**
     * 设置别名
     */
    private Target setTage(String cid) {
        Target target = new Target();
        target.setAppId(PushConstant.appId);
        target.setAlias(cid);
        return target;
    }


}
