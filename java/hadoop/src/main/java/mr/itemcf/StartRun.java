package mr.itemcf;

import org.apache.hadoop.conf.Configuration;

import java.util.HashMap;
import java.util.Map;

public class StartRun {
    public static void main(String[] args) {
        //默认加载src 下的配置文件
        Configuration conf = new Configuration();
        conf.set("mapreduce.app-submission.cross-platform", "true");    //跨平台提交
        conf.set("mapred.jar","F:\\workstation\\java\\hadoop\\target\\hadoop-1.0-SNAPSHOT.jar");

        // 所有 mr 的输入和输出目录定义在map集合中
        Map<String,String> paths = new HashMap<String,String>();
        paths.put("Step1Input",         "/usr/itemcf/input/(sample)sam_tianchi_2014002_rec_tmall_log.csv");
        paths.put("Step1Output",        "/usr/itemcf/Output/step1");
        paths.put("Step2Input",         "/usr/itemcf/Output/step1");
        paths.put("Step2Output",        "/usr/itemcf/Output/step2");
        paths.put("Step3Input",         "/usr/itemcf/Output/step2");
        paths.put("Step3Output",        "/usr/itemcf/Output/step3");
        paths.put("Step4Input1",        "/usr/itemcf/Output/step2");
        paths.put("Step4Input2",        "/usr/itemcf/Output/step3");
        paths.put("Step4Output",        "/usr/itemcf/Output/step4");
        paths.put("Step5Input",         "/usr/itemcf/Output/step4");
        paths.put("Step5Output",        "/usr/itemcf/Output/step5");
        paths.put("Step6Input",         "/usr/itemcf/Output/step5");
        paths.put("Step6Output",        "/usr/itemcf/Output/step6");

        Step1.run(conf, paths);
        Step2.run(conf, paths);
        Step3.run(conf, paths);
        Step4.run(conf, paths);
        Step5.run(conf, paths);
        Step6.run(conf, paths);
    }

    public static Map<String, Integer> R = new HashMap<>();
    static {
        R.put("click",          1);
        R.put("collect",        2);
        R.put("cart",           3);
        R.put("alipay",         4);
    }
}


