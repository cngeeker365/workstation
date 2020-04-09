package com.jdk.highLevel.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author taobaibai
 * @create 2020-04-06 11:47
 */
public class TestFileChannel {
    public static void main(String[] args) throws Exception {
        hardFileChannel();
    }

    public static void hardFileChannel() throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(2); //2字节
        FileChannel fc = FileChannel.open(Paths.get("F:\\workstation\\java\\java-base\\src\\main\\java\\com\\jdk\\highLevel\\nio\\data.txt"), StandardOpenOption.READ);
        int len=-1;
        do {
            len = fc.read(buf);
            buf.flip(); //切换读模式
            while (buf.hasRemaining()) { //判断有没有数据
                System.out.println((char)buf.get());
            }
            buf.flip(); //切换写模式
            buf.clear();
        }while (len!=-1);

        fc.close();
    }

    public static void sampleFileChannel() throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1024*1024); //1M
        FileChannel fc = FileChannel.open(Paths.get("F:\\workstation\\java\\java-base\\src\\main\\java\\com\\jdk\\highLevel\\nio\\data.txt"), StandardOpenOption.READ);
        fc.read(buf);
        buf.flip(); //切换读写模式
        byte[] array = buf.array();
        System.out.println(new String(array));
        fc.close();
    }
}
