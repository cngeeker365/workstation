package springboot.demo.day02.logback;

import springboot.demo.day02.mybatis.domain.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taobaibai
 * @create 2020-04-01 20:05
 */
@RestController
@RequestMapping("/api/v1/logback")
public class LogbackController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("log")
    public Object testLog(){
        logger.debug("this is debug");
        logger.info("this is info");
        logger.warn("this is warn");
        logger.error("this is debug");
        return JsonData.buildSuccess();
    }
}
