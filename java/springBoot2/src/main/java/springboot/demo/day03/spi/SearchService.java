package springboot.demo.day03.spi;

import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-05 20:18
 */
public interface SearchService {
    List<Object> search(String keyword);
}
