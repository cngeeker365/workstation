package dubbo.demo.annotation.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import dubbo.demo.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author taobaibai
 * @create 2020-05-11 22:21
 */
@Component
public class ConsumerService {
    @Reference
    private ProviderService providerService;

    public String doSayHello(String name){
        return providerService.sayHello(name);
    }
}
