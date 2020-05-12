package dubbo.demo.annotation.provider;

import com.alibaba.dubbo.config.annotation.Service;
import dubbo.demo.ProviderService;

/**
 * 注解方式实现类
 * @author taobaibai
 * @create 2020-05-11 21:32
 */
@Service(timeout = 5000)
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String word) {
        return word;
    }
}
