package cn.shine365.demo.day01.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author taobaibai
 * @create 2020-03-31 21:58
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("==================requestDestroyed==================");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("==================requestInitialized==================");
    }
}
