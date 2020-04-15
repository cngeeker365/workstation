package com.jdk.wangwenjun.chapter2.c12_balking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author taobaibai
 * @create 2020-04-15 15:22
 */
public class BalkingData {
    private final String fileName;
    private String content;
    private boolean changed;

    public BalkingData(String fileName, String content){
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if(!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " call do save, content=" + content);
        File file;
        Writer writer = new FileWriter(fileName,true);
        writer.write(content);
        writer.write("\n");
        writer.flush();
        writer.close();
    }
}
