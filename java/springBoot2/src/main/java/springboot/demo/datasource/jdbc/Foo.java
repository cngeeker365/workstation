package springboot.demo.datasource.jdbc;

import lombok.Builder;
import lombok.Data;

/**
 * @author taobaibai
 * @create 2020-05-27 22:41
 */
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
