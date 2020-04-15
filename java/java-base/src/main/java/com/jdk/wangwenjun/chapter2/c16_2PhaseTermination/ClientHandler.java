package com.jdk.wangwenjun.chapter2.c16_2PhaseTermination;

import java.io.*;
import java.net.Socket;

/**
 * @author taobaibai
 * @create 2020-04-15 21:10
 */
public class ClientHandler implements Runnable {
    private final Socket socket;
    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (   //try-resource at JDK1.8
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                //装饰器设计模式
                BufferedReader br = new BufferedReader( new InputStreamReader( inputStream ) );
                PrintWriter printWriter = new PrintWriter(outputStream);
                ){
            while (running){
                String msg = br.readLine();
                if(msg==null){
                    break;
                }
                System.out.println("Come from client ["+Thread.currentThread().getName()+"] > " + msg);
                printWriter.write("echo "+msg+"\n");
                printWriter.flush();
            }
        } catch (IOException e) {
            this.running = false;
        } finally {
            this.stop();
        }
    }

    public void stop(){
        if(!running){
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
