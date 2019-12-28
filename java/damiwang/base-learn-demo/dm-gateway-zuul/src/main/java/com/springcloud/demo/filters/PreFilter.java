package com.springcloud.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@RefreshScope
public class PreFilter extends ZuulFilter {
    @Value("${token}")
    private boolean token;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;    //过滤器类型
    }

    @Override
    public int filterOrder() {
        return 0;   //同类型之间的优先级，越大越低
    }

    @Override
    public boolean shouldFilter() {
        return true;    //过滤器是否起作用
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

/*        String token = request.getHeader("token");
        if (token==null || token.equals("")){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"msg\":\"401, access without permission, pls login firtst. \"}");
            return "access denied";
        }
        return "pass";*/
        System.out.println("============================"+token+"============================");
        if (token) {
            String key = request.getParameter("key");
            System.out.println(key + " access filter 1!");
            ctx.set("thirdfilter", true);
            if ("1".equals(key)) {
                ctx.setSendZuulResponse(false);
            } else if ("".equals(key)) {
                ctx.set("thirdfilter", false);
            }
            return null;
        }
        return null;
    }
}
