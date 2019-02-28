package com.chengchengtech.util.verify;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/5/2
 * Time: 上午10:25
 * Org : 思笛恩
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class RandomUtil {

    private static final String VERIFY_CODE_BASE="0123456789";

    public static String getRandomNumCode(int count) {
        String codeNum = "";
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            //目的是产生足够随机的数，避免产生的数字重复率高的问题
            int next = random.nextInt(10000);
            codeNum += numbers[next % 10];
        }
        return codeNum;
    }
}
