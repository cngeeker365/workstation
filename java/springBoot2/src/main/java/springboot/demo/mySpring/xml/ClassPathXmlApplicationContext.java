package springboot.demo.mySpring.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-05 21:06
 */
public class ClassPathXmlApplicationContext {
    private Map<String, Object> instanceMap = new HashMap<>(); //存储bean实例
    private Map<String, BeanDefinition> beanMap = new HashMap<>(); //存储bean对象配置信息
    public ClassPathXmlApplicationContext(String file) {
        //1. 读取配置文件
        InputStream in = getClass().getClassLoader().getResourceAsStream(file);
        //2. 解析文件封装数据
        try {
            parse(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 本次xml解析基于 dom 实现
     * 市场主流xml解析：dom，dom4j，sax，pull，……
     * @param in
     */
    private void parse(InputStream in) throws Exception {
        //1. 创建解析器对象（负责读取xml文件内容）
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //2. 解析流对象
        Document doc = builder.parse(in);
        //3. 处理document
        processDocument(doc);
    }
    private void processDocument(Document doc) throws Exception{
        //1. 获取所有bean元素
        NodeList list = doc.getElementsByTagName("bean");
        //2. 迭代bean元素，对其配置信息进行封装
        for(int i=0;i<list.getLength();i++){
            //一个node对象对应一个BeanDefinition对象
            Node node = list.item(i); //bean
            NamedNodeMap nMap = node.getAttributes();
            BeanDefinition bd = new BeanDefinition();
            bd.setId(nMap.getNamedItem("id").getNodeValue());
            bd.setPkgClass(nMap.getNamedItem("class").getNodeValue());
            bd.setLazy(Boolean.valueOf(nMap.getNamedItem("lazy").getNodeValue()));
            //存储配置信息
            beanMap.put(bd.getId(), bd);
            //基于配置信息中lazy属性的值，判定此类的实例是否延迟加载
            if(!bd.getLazy()){
                Object obj = newBeanInstance(bd.getPkgClass());
                instanceMap.put(bd.getId(),obj);
            }
        }
    }

    private Object newBeanInstance(String pkgClass) throws Exception {
        Class<?> cls = Class.forName(pkgClass);
        Constructor<?> con = cls.getDeclaredConstructor();
        con.setAccessible(true);
        return con.newInstance();
    }

    public <T> T getBean(String key, Class<T> t) throws Exception {
        //1. 判定当前instanceMap中是否有bean的实例
        Object obj = instanceMap.get(key);
        if(obj!=null) return (T)obj;
        //2. 实例map中没有对象则创建对象，然后存储到map中
        obj = newBeanInstance(t.getName());
        instanceMap.put(key, obj);
        return (T)obj;
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("testa.xml");
        Object obj = ctx.getBean("obj",Object.class);
        Date date = ctx.getBean("date", Date.class);
        System.out.println(obj.getClass());
        System.out.println(date.getTime());
    }
}
