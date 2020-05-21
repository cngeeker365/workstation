package cn.dm.controller;

import cn.dm.common.Dto;
import cn.dm.common.DtoUtil;
import cn.dm.common.EmptyUtils;
import cn.dm.common.MD5;
import cn.dm.pojo.DmUser;
import cn.dm.service.DmLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.AuthProvider;

/**
 * @author taobaibai
 * @create 2020-04-27 17:13
 */
@RestController
@RequestMapping("/api")
public class DmUserController {
    @Autowired
    private DmLoginService dmLoginService;

    @RequestMapping(value = "/p/login", method = RequestMethod.POST)
    public Dto loginByPassword(@RequestBody DmUser dmUser) throws Exception {
        dmUser.setPassword(MD5.getMd5(dmUser.getPassword(), 32));

        Object[] results = dmLoginService.login(dmUser);
        if (EmptyUtils.isEmpty(results)) {
            return DtoUtil.returnFail("登录失败", "0000");
        }else {
            return DtoUtil.returnSuccess("登录成功", results);
        }
    }
}