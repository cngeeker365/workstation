package com.jdk.wangwenjun.chapter3.c03_encryptClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author taobaibai
 * @create 2020-04-16 20:33
 */
public class DecryptClassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "F:\\";
    private String dir = DEFAULT_DIR;
    public DecryptClassLoader(){
        super();
    }
    public DecryptClassLoader(ClassLoader parent){
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File clazzFile = new File(dir, classPath+".class");
        if(!clazzFile.exists()){
            throw new ClassNotFoundException("The class "+name+" not found under directory ["+dir+"]");
        }
        byte[] clazzBytes = loadClassBytes(clazzFile);
        if(null == clazzBytes || clazzBytes.length==0){
            throw new ClassNotFoundException("load the class "+name+" failed.");
        }
        return this.defineClass(name, clazzBytes, 0, clazzBytes.length);
    }

    private byte[] loadClassBytes(File clazzFile) {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(clazzFile);
        ) {
            int data;
            while ( ( data=fis.read() ) != -1 ){
                baos.write(data ^ EncryptUtils.ENCRYPT_FACTOR);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}
