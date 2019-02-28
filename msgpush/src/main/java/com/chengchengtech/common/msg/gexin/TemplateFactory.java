package com.chengchengtech.common.msg.gexin;


import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gexin.rp.sdk.template.style.Style0;

/**
 * @author lixiang
 * @version V1.0
 * @Title: TemplateFactory
 * @Description: TODO
 * @date 2018/3/13 16:03
 */
public class TemplateFactory {


    /**
     * 通知模板  点击打开应用
     */
    public static NotificationTemplate notificationTemplate(NotificationPushReq req) {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(PushConstant.appId);
        template.setAppkey(PushConstant.appKey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(1);
        template.setTransmissionContent(req.getContent());
        // 设置定时展示时间

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(req.getTitle());
        style.setText(req.getText());
        // 配置通知栏图标
        //style.setLogo("icon.png");
        // 配置通知栏网络图标
        //style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);

        return template;
    }

    /**
     * ios 推送模板
     */
    public static TransmissionTemplate iosTemplate(String content) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(PushConstant.appId);
        template.setAppkey(PushConstant.appKey);
        //透传内容
        template.setTransmissionContent(content);
        template.setTransmissionType(2);
        APNPayload payload = new APNPayload();
        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge("+1");
        payload.setContentAvailable(1);
        //通知铃声
        payload.setSound("default");
        payload.setCategory("$由客户端定义");

        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));

        //字典模式使用APNPayload.DictionaryAlertMsg
        //payload.setAlertMsg(getDictionaryAlertMsg());

        // 添加多媒体资源
        //payload.addMultiMedia(new MultiMedia().setResType(MultiMedia.MediaType.video)
        //.setResUrl("http://ol5mrj259.bkt.clouddn.com/test2.mp4")
        //.setOnlyWifi(true));

        template.setAPNInfo(payload);
        return template;
    }


    /**
     * 自定义模板
     * 推送给app内部
     */
    public static TransmissionTemplate androidtTemplate(String content) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(PushConstant.appId);
        template.setAppkey(PushConstant.appKey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(2);
        template.setTransmissionContent(content);
        // 设置定时展示时间
        return template;
    }
}
