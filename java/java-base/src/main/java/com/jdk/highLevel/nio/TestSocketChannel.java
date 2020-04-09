package com.jdk.highLevel.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author taobaibai
 * @create 2020-04-06 14:35
 */
public class TestSocketChannel {
    /**
     * 创建服务
     */
    @Test
    public void testServer() throws IOException {
        //1. 创建ServerSocketChannel对象
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2. 让对象在指定端口进行监听
        ssc.socket().bind(new InetSocketAddress(19999));
        //3. 构建一个Buffer对象，用于存储读取的数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4. 等待客户端连接
        while (true){
            SocketChannel sc = ssc.accept();
            System.out.println("Client connected...");
            sc.read(buffer);
            buffer.flip();
            System.out.println("Server: "+new String(buffer.array()));
            sc.close();
        }
    }

    /**
     * 创建客户端
     */
    @Test
    public void testClient() throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("127.0.0.1", 19999));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello server".getBytes());
        buffer.flip();
        sc.write(buffer);
        System.out.println(new String(buffer.array()));
        sc.close();
    }
}
