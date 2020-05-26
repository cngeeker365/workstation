package springboot.demo.day03.spi;

import java.util.ServiceLoader;

/**
 * TODO：实验没有成功！！！
 * @author taobaibai
 * @create 2020-04-05 20:23
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<SearchService> services = ServiceLoader.load(SearchService.class);
        for (SearchService service: services){
            System.out.println(service.getClass());
            service.search("hello world");
        }
    }
}
