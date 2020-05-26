package springboot.demo.day01.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author taobaibai
 * @create 2020-03-31 22:18
 */
public class LoginIntercepter implements HandlerInterceptor {

    /*
     * 进入 Controller 方法之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginIntercepter--------------------->preHandle");
//        String token = request.getParameter("access_token");
//        response.getWriter().print("Fail");
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntercepter--------------------->postHandle");
        HandlerInterceptor.super.postHandle(request,response,handler, modelAndView);
    }

    /*
     * 整个完成之后，通常用于资源清理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginIntercepter--------------------->afterCompletion");
        HandlerInterceptor.super.afterCompletion(request,response,handler, ex);
    }
}
