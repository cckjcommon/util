package com.chengchengtech.common.rid.filter;

import com.chengchengtech.common.rid.filter.mo.RequestInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author lixiang
 * @version V1.0
 * @Title: RequestIdentityFilter
 * @Description: TODO
 * @date 2018/4/16 14:50
 */
public class RequestIdentityFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestIdentityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("RequestIdentity过滤器启动");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = null;
        HttpServletResponse resp = null;
        try {
            String rid, name, version, step;
            req = ((HttpServletRequest) request);
            resp = (HttpServletResponse) response;
            // //允许跨域
            resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            resp.setHeader("Access-Control-Allow-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,sessionKey");
            // 上层调用者传递请求唯一标志,优先从header中取
            rid = req.getHeader("rid");
            // 其次从参数中查找
            rid = StringUtils.isEmpty(rid) ? request.getParameter("_rid") : rid;
            if (StringUtils.isEmpty(rid)) {
                // 如果调用方未传递,则自动生成
                rid = RequestIdentityHolder.generateRid();
                name = RequestIdentityHolder.getName();
                version = RequestIdentityHolder.getVersion();
                step = "0";
            } else {
                step = req.getHeader("rstep");
                // 如果存在RID,则至少是第二跳
                step = StringUtils.isEmpty(step) ? request.getParameter("_rstep") : step;
                step = StringUtils.isEmpty(step) ? "1" : step;
                name = req.getHeader("rname");
                name = StringUtils.isEmpty(name) ? request.getParameter("_rname") : name;
                if (!StringUtils.isEmpty(name)) {
                    name = URLDecoder.decode(name, "UTF-8");
                }
                version = req.getHeader("rversion");
                version = StringUtils.isEmpty(version) ? request.getParameter("_rversion") : version;
            }
            // 该方式能够在高并发时减少大量对象的创建与回收操作,提高效率
            RequestInfo requestInfo = RequestIdentityHolder.get(true);
            requestInfo.setId(rid);
            requestInfo.setIp(req.getRemoteAddr());
            requestInfo.setStep(Integer.valueOf(step) + 1);
            requestInfo.setName(name);
            requestInfo.setVersion(version);
            RequestIdentityHolder.set(requestInfo);
        } catch (Exception e) {
            LOGGER.warn("拦截RequestIdentity信息时出现错误", e);
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("RequestIdentity过滤器销毁");
        }
    }
}
