package springboot.demo.day01.controller;

import springboot.demo.day01.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author taobaibai
 * @create 2020-04-01 8:33
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    private ServerSettings settings;

    @GetMapping("hello")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("setting", settings);
        return "fm/index";
    }
}
