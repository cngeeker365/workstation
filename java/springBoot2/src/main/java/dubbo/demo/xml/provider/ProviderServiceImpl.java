package dubbo.demo.xml.provider;

import dubbo.demo.ProviderService;

/**
 * @author taobaibai
 * @create 2020-05-11 21:32
 */
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String word) {
        return word;
    }
}
