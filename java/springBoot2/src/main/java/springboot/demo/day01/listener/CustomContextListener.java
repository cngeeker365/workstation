package springboot.demo.day01.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author taobaibai
 * @create 2020-03-31 22:06
 */
@WebListener
public class CustomContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("==================contextDestroyed==================");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==================contextInitialized==================");
    }
}
