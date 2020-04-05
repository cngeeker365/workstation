package cn.shine365.demo.mySpring.xml;

import java.io.Serializable;

/**
 * 基于此对象存储Bean的配置信息
 * @author taobaibai
 * @create 2020-04-05 21:00
 */
public class BeanDefinition implements Serializable {
    private String id; //bean id
    private String pkgClass;
    private Boolean lazy=false; //延迟加载

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPkgClass() {
        return pkgClass;
    }

    public void setPkgClass(String pkgClass) {
        this.pkgClass = pkgClass;
    }

    public Boolean getLazy() {
        return lazy;
    }

    public void setLazy(Boolean lazy) {
        this.lazy = lazy;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "id='" + id + '\'' +
                ", pkgClass='" + pkgClass + '\'' +
                ", lazy=" + lazy +
                '}';
    }
}
