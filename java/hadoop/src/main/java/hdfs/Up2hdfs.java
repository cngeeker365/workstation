package hdfs;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URI;

public class Up2hdfs {
    FileSystem  fs;
    Configuration conf;
    @Before
    public void begin() throws Exception{
        conf = new Configuration();
        // conf.set("fs.defaultFS", "http://activeNN:port");
        // fs = FileSystem.get(conf);
        fs = FileSystem.get(new URI("hdfs://testa"), conf, "root");
    }

    @After
    public void end(){
        try {
            fs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void mkdir() throws Exception{
        Path path = new Path("/wc");
        fs.mkdirs(path);
    }

    @Test
    public void list() throws Exception{
        Path path = new Path("/wc");
        FileStatus[] fss = fs.listStatus(path);
        for (FileStatus s: fss) {
            System.out.println(s.getPath()+"-"+s.getLen()+"-"+s.getAccessTime());
        }
    }

    @Test
    public void upload() throws Exception{
//        Path path = new Path("/wc/input/wc");
        Path path = new Path("/weather/input/tq");
        FSDataOutputStream outputStream = fs.create(path);
        FileUtils.copyFile(new File("F://workstation//java//hadoop//src//main//java//mr//weather//tq"), outputStream);
    }

    /**
     * 小文件合并上传
     * @throws Exception
     */
    @Test
    public void upload2() throws Exception{
        Path path = new Path("/tmp/seq");
        SequenceFile.Writer writer = SequenceFile.createWriter(fs, conf, path, Text.class, Text.class);
        File file = new File("D://test");
        for(File f : file.listFiles()){
            writer.append(new Text(f.getName()), new Text(FileUtils.readFileToString(f)));
        }
    }

    /**
     * 合并后的小文件下载
     */
    @Test
    public void download2() throws Exception{
        Path path = new Path("/tmp/seq");
        SequenceFile.Reader reader = new SequenceFile.Reader(fs, path, conf);
        Text key = new Text();
        Text val = new Text();
        while (reader.next(key, val)){
            System.out.println(key);
            System.out.println(val);
            System.out.println("---------------------");
        }
    }
}


