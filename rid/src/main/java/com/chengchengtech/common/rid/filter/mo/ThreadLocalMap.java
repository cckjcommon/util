package com.chengchengtech.common.rid.filter.mo;


import com.chengchengtech.common.rid.filter.RequestIdentityHolder;

/**
 * @author lixiang
 * @version V1.0
 * @Title: ThreadLocalMap
 * @Description: TODO
 * @date 2018/4/16 15:38
 */
public class ThreadLocalMap extends InheritableThreadLocal<RequestInfo> {

    protected RequestInfo childValue(RequestInfo parentValue) {
        return RequestIdentityHolder.join(parentValue);
    }


}
