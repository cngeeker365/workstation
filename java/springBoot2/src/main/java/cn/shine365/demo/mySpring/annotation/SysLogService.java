package cn.shine365.demo.mySpring.annotation;

/**
 * @author taobaibai
 * @create 2020-04-05 21:42
 */
@Svc("sysLogService")
@Lazi(true)
public class SysLogService {
    public SysLogService() {
        System.out.println(SysLogService.class.getName());
    }
}
