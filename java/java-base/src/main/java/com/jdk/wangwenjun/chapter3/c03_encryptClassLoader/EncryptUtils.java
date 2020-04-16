package com.jdk.wangwenjun.chapter3.c03_encryptClassLoader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author taobaibai
 * @create 2020-04-16 20:25
 */
public final class EncryptUtils {
    public static final byte ENCRYPT_FACTOR = (byte)0xff;
    private EncryptUtils(){
        //empty
    }
    public static void doEncrypt(String src, String dest){
        try(
                FileInputStream fis = new FileInputStream(src);
                FileOutputStream fos = new FileOutputStream(dest);
                ) {
            int data;
            while ((data=fis.read())!=-1){
                fos.write(data ^ ENCRYPT_FACTOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        doEncrypt("F:\\tmp\\aaa.txt", "F:\\tmp\\bbb.txt");
//        doEncrypt("F:\\tmp\\bbb.txt", "F:\\tmp\\ccc.txt");
        doEncrypt("F:\\tmp\\com\\jdk\\wangwenjun\\chapter3\\c02_myclassloader\\MyObject.class", "F:\\com\\jdk\\wangwenjun\\chapter3\\c02_myclassloader\\MyObject.class");
    }
}
