package job.bigfile.nio;

import lombok.SneakyThrows;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author taobaibai
 * @create 2020-05-30 15:16
 */
public class TestNIO_01 {
    @Test
    public void test_01() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("F:\\Car.java", "r");
        FileChannel inChannel = aFile.getChannel();
        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);
        //read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //make buffer ready for read
            buf.flip();
            while(buf.hasRemaining()){
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }
            //make buffer ready for writing
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    @Test
    public void test_02() throws Exception{
        long start = System.currentTimeMillis();
        RandomAccessFile aFile = new RandomAccessFile("F:\\yelp_academic_dataset_review.json", "r");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = inChannel.read(buffer);
        int count = 0;
        ByteBuffer tmp = ByteBuffer.allocate(4096);

        while (bytesRead != -1){
            buffer.flip();

            while (buffer.hasRemaining()){
                byte b = buffer.get();
                if(b==10 || b==13){
                    tmp.flip();
                    final String line = Charset.forName("utf-8").decode(tmp).toString();
                    count++;
                    System.out.println(count+"\t"+line);
                    tmp.clear();
                }else {
                    if(tmp.hasRemaining()){
                        tmp.put(b);
                    }else {
                        tmp = reAllocate(tmp);
                        tmp.put(b);
                    }
                }
            }
            if(count>=1000000){
                break;
            }
            buffer.clear();
            bytesRead = inChannel.read(buffer);
        }
        System.out.println(System.currentTimeMillis()-start);
        aFile.close();
    }

    @Test
    public void test_03() throws Exception{
        FileInputStream fis = new FileInputStream("F:\\yelp_academic_dataset_review.json");
        long start = System.currentTimeMillis();
        try (InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(inputStreamReader);
        ) {
          int count = 0;
          String line = br.readLine();
          while (line != null){
              count++;
              if(count>=1000000){
                  break;
              }
              System.out.println(count+"\t"+line);
              line = br.readLine();
          }
            System.out.println(System.currentTimeMillis()-start);
        }
    }

    private static ByteBuffer reAllocate(ByteBuffer stringBuffer) {
        final int capacity = stringBuffer.capacity();
        byte[] newBuffer = new byte[capacity * 2];
        System.arraycopy(stringBuffer.array(), 0, newBuffer, 0, capacity);
        return (ByteBuffer) ByteBuffer.wrap(newBuffer).position(capacity);
    }
}
