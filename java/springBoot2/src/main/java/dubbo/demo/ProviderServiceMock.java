package dubbo.demo;

/**
 * @author taobaibai
 * @create 2020-05-11 21:31
 */
public class ProviderServiceMock implements ProviderService {
    @Override
    public String sayHello(String word) {
        //降级逻辑
        return "降级逻辑处理结果";
    }
}
