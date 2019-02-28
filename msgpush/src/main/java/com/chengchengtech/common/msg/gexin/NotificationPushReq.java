package com.chengchengtech.common.msg.gexin;

import com.chengchengtech.common.msg.PushRequest;
import lombok.Data;

@Data
public class NotificationPushReq implements PushRequest{

    private String mobile;

    /**
     * 透传信息
     */
    private String content;

    /**
     * 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
     */
    private String transmissionType;

    /**
     * 通知栏标题
     */
    private String title;

    /**
     * 通知栏内容
     */
    private String text;

}
