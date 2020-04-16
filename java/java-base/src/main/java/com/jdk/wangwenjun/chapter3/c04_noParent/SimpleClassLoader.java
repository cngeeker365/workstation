package com.jdk.wangwenjun.chapter3.c04_noParent;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author taobaibai
 * @create 2020-04-16 17:20
 */
public class SimpleClassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "F:\\tmp";
    private String dir = DEFAULT_DIR;
    private String classLoaderName;

    public SimpleClassLoader(){
        super();
    }

    public SimpleClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public SimpleClassLoader(String classLoaderName, ClassLoader parent){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /**
     * xxx.xxx.xxx.xxx.AAA => xxx/xxx/xxx/xxx/AAA.class
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String clazzPath = name.replace(".","/");
        File clazzFile = new File(dir, clazzPath+".class");
        if(!clazzFile.exists()){
            throw new ClassNotFoundException("The class "+name+" not found under "+dir);
        }
        byte[] clazzBytes = loadClassBytes(clazzFile);
        if(null == clazzBytes || clazzBytes.length==0){
            throw new ClassNotFoundException("load the class "+name+" failed.");
        }
        return this.defineClass(name, clazzBytes, 0, clazzBytes.length);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;
        if(name.startsWith("java.")){
            try {
                ClassLoader system = ClassLoader.getSystemClassLoader();
                clazz = system.loadClass(name);
                if(clazz!=null){
                    if(resolve){
                        resolveClass(clazz);
                    }
                    return clazz;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            clazz = findClass(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(clazz==null && getParent()!=null){
            clazz = getParent().loadClass(name);
        }
        return clazz;
    }

    private byte[] loadClassBytes(File clazzFile) {
        try( ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(clazzFile);
        ) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ( ( len=fis.read(buffer) ) != -1 ){
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}
