package com.chengchengtech.util.verify;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2017/11/24
 * Time: 上午12:05
 * Org : 思笛恩
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class CheckUtil {

    public static boolean isEmpty(Object object, String... defaultValue) {
        boolean result = true;
        if (object == null) {
            return result;
        } else if (object instanceof String) {
            String temp = (String) object;
            if (!StringUtils.isEmpty(temp)) {
                result = false;
            } else {
                if (defaultValue != null && defaultValue.length == 1) {
                    if (!defaultValue[0].equalsIgnoreCase(temp)) {
                        result = false;
                    }
                }
            }
        } else if (object instanceof Integer) {
            int temp = (int) object;
            if (defaultValue.length == 0) {
                if (temp != 0) {
                    result = false;
                }
            } else {
                if (temp != Integer.valueOf(defaultValue[0])) {
                    result = false;
                }
            }
        } else if (object instanceof Long) {
            long temp = (long) object;
            if (defaultValue.length == 0) {
                if (temp != 0) {
                    result = false;
                }
            } else {
                if (temp != Long.valueOf(defaultValue[0])) {
                    result = false;
                }
            }
        } else if (object instanceof Map) {
            Map temp = (Map) object;
            if (!temp.isEmpty()) {
                result = false;
            }
        } else if (object instanceof List) {
            List temp = (List) object;
            if (!temp.isEmpty()) {
                result = false;
            }
        } else if (object instanceof Queue) {
            Queue temp = (Queue) object;
            if (!temp.isEmpty()) {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 校验参数是否合法：为空不合法
     *
     * @param objects
     * @return
     */
    public static CheckResult isLegal(Object... objects) {
        if (objects == null || objects.length <= 0) {
            return new CheckResult(false, -1);
        } else {
            for (int i = 0; i < objects.length; i++) {
                if (CheckUtil.isEmpty(objects[i])) {
                    return new CheckResult(false, i,objects[i]+" is not legal.");
                }
            }
            return new CheckResult(true, -1);
        }
    }


}
