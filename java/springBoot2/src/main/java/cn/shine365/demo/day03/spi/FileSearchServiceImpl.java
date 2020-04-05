package cn.shine365.demo.day03.spi;

import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-05 20:19
 */
public class FileSearchServiceImpl implements SearchService {
    @Override
    public List<Object> search(String keyword) {
        System.out.println("FileSearchService");
        return null;
    }
}
