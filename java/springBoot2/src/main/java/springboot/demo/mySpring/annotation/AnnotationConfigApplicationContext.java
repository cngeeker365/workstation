package springboot.demo.mySpring.annotation;

import springboot.demo.mySpring.xml.BeanDefinition;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-05 21:48
 */
public class AnnotationConfigApplicationContext {
    private Map<String, Object> instanceMap = new HashMap<>(); //存储bean实例
    private Map<String, BeanDefinition> beanMap = new HashMap<>(); //存储bean对象配置信息

    public AnnotationConfigApplicationContext(Class<?> cls) throws Exception {
        //1. 读取配置类中指定的包名
        ScanComponent sc = cls.getDeclaredAnnotation(ScanComponent.class);
        String pkg = sc.value();
        //2. 扫描指定包中的类
        String clsPath = pkg.replace(".","/");
        URL url = cls.getClassLoader().getResource(clsPath);
        File file = new File(url.getPath());
        File[] clsFiles = file.listFiles((File f) -> f.isFile()&&f.getName().endsWith(".class"));
        //3. 封装文件信息
        processClassFiles(pkg, clsFiles);
    }

    private void processClassFiles(String pkg, File[] clsFiles) throws Exception {
        for (File file : clsFiles) {
            String pkgCls = pkg +"."+file.getName().substring(0, file.getName().lastIndexOf("."));
            Class<?> targetCls = Class.forName(pkgCls);
            Svc svc = targetCls.getDeclaredAnnotation(Svc.class);
            if(svc==null){
                continue;
            }
            Lazi lazi = targetCls.getDeclaredAnnotation(Lazi.class);
            BeanDefinition bd = new BeanDefinition();
            bd.setId(svc.value());
            bd.setPkgClass(pkgCls);
            if(lazi!=null){
                bd.setLazy(lazi.value());
            }
            beanMap.put(bd.getId(), bd);
            if(!bd.getLazy()){
                Object obj = newBeanInstance(targetCls);
                //TODO: 思考：为对象属性注入值（获取属性，获取属性上的 @Autowired ）
                instanceMap.put(bd.getId(),obj);
            }
        }
    }

    private Object newBeanInstance(Class<?> targetCls) throws Exception {
        Constructor<?> con = targetCls.getDeclaredConstructor();
        con.setAccessible(true);
        return con.newInstance();
    }

    public <T> T getBean(String key, Class<T> t) throws Exception {
        //1. 判定当前instanceMap中是否有bean的实例
        Object obj = instanceMap.get(key);
        if(obj!=null) {
            return (T)obj;
        }
        //2. 实例map中没有对象则创建对象，然后存储到map中
        obj = newBeanInstance(t);
        instanceMap.put(key, obj);
        return (T)obj;
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        SysLogService logService = ctx.getBean("SysLogService", SysLogService.class);
//        System.out.println("ls="+logService);
    }
}
