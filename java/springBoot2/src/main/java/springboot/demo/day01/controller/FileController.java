package springboot.demo.day01.controller;

import springboot.demo.day01.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author taobaibai
 * @create 2020-03-31 11:52
 */
@Controller
@PropertySource({"classpath:config/application.properties"})
public class FileController {

    @RequestMapping("/api/v1/index")
    public Object index(){
        return "index";
    }

    @Value("${web.file.path}")
    private static String filePath ;
//    private static final String filePath = "F:\\resources\\static\\images\\";


    @RequestMapping(value = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        //file.isEmpty(); 判断图片是否为空
        //file.getSize(); 图片大小进行判断

        String name = request.getParameter("name");
        System.out.println("用户名："+name);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        // 文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:"+fileName);

        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);

            return new JsonData(0, fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new JsonData(-1, "fail to save ", null);
    }
}
