package com.chengchengtech.common.msg.gexin;

import com.chengchengtech.common.msg.PushRequest;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 下午12:06
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
@Data
public class PushMessageRequest implements PushRequest {

    /**
     * 推送目标
     */
    private String mobile;

    /**
     * 推送内容
     */
    private String content;

}
