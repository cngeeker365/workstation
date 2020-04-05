package cn.shine365.demo.mySpring.annotation;

/**
 * @author taobaibai
 * @create 2020-04-05 21:47
 */
@Lazi(false)
@Svc("sysUserService")
public class SysUserService {
    public SysUserService() {
        System.out.println(SysUserService.class.getName());
    }
}
