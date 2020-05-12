package dubbo.demo.annotation.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 注解启动方式
 * @author taobaibai
 * @create 2020-05-11 21:40
 */
public class Provider {
    public static void main( String[] args ) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        context.start();
        System.in.read(); // 按任意键退出
    }
}
