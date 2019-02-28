package com.chengchengtech.test;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/2/26
 * Time: 下午4:23
 * Org : 承辰科技
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class Test {
    private static int appid = 1400070765;
    private static String appkey = "20235b39c8377bf8e4f35319b716aa18";

    public static void main(String[] args) {
        try {
            SmsSingleSender sender = new SmsSingleSender(appid, appkey);
            ArrayList<String> params = new ArrayList();
            params.add("4212");
            params.add("2");
            SmsSingleSenderResult result = sender.sendWithParam("86","18019235579",89465, params,  "", "","");
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
