package com.jdk.wangwenjun.chapter4.c03_unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * @author taobaibai
 * @create 2020-04-18 10:41
 */
public class UnsafeFooTest {

    /**
     * 通过反射方式可以获取到 Unsafe
     * @return
     */
    private static Unsafe getUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载 class 内容
     * @return
     * @throws Exception
     */
    private static byte[] loadClassContent() throws Exception {
        File file = new File("F:\\tmp\\com\\jdk\\wangwenjun\\chapter3\\c02_myclassloader\\MyObject.class");
        FileInputStream fis = new FileInputStream(file);
        byte[] content = new byte[(int)file.length()];
        fis.read(content);
        fis.close();
        return content;
    }

    /**
     * 评估对象大小
     * @param obj
     * @return
     */
    private static long sizeOf(Object obj){
        Unsafe unsafe = getUnsafe();
        Set<Field> fields = new HashSet<>();
        Class c = obj.getClass();
        while (c!=Object.class){
            Field[] declaredFields = c.getDeclaredFields();
            for (Field f: declaredFields) {
                if((f.getModifiers() & Modifier.STATIC)==0){
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }
        long maxOffSet = 0;
        for(Field f: fields){
            long offSet = unsafe.objectFieldOffset(f);
            if(offSet>maxOffSet){
                maxOffSet = offSet;
            }
        }
        return ((maxOffSet/8)+1)*8;
    }

    static class Simple{
        private long l = 0;
        private int i = 10;
        private byte b = (byte)0x01;

        public Simple() {
            this.l = 1;
            System.out.println("=========================");
        }

        public long get() {
            return l;
        }
    }
    static class Guard{
        private int ACCESS_ALLOWED = 1;
        private boolean allow(){
            return 42 == ACCESS_ALLOWED;
        }
        public void work(){
            if(allow()){
                System.out.println("I am working by allowed.");
            }
        }
    }

    @Test
    public void test_01() throws Exception {
        Simple simple = new Simple();
        System.out.println(simple.get());

        Simple simple1 = Simple.class.newInstance();

        Class.forName("com.jdk.wangwenjun.chapter4.c03_unsafe.UnsafeFooTest$Simple");

        Unsafe unsafe = getUnsafe();
        //绕过初始化，直接开辟内存空间
        Simple simple2 = (Simple)unsafe.allocateInstance(Simple.class);
        System.out.println(simple2.get());
        System.out.println(simple2.getClass());
        System.out.println(simple2.getClass().getClassLoader());

        System.out.println("===========================================================");

        Guard guard = new Guard();
        //不允许
        guard.work();

        Field field = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        //直接去内存赋值，绕过鉴权
        unsafe.putInt(guard, unsafe.objectFieldOffset(field), 42);
        guard.work();

        System.out.println("===========================================================");

        byte[] bytes = loadClassContent();
        Class clazz = unsafe.defineClass(null, bytes, 0, bytes.length, null, null);
        String v = (String)clazz.getMethod("hello").invoke(clazz.newInstance(), null);
        System.out.println(v);

        System.out.println("===========================================================");

        System.out.println(sizeOf(new Simple()));
    }
}
