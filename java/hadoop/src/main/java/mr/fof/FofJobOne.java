package mr.fof;

import mr.weather.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FofJobOne {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //默认加载src 下的配置文件
        Configuration conf = new Configuration();
        conf.set("mapreduce.app-submission.cross-platform", "true");    //跨平台提交
        conf.set("mapred.jar","F:\\workstation\\java\\hadoop\\target\\hadoop-1.0-SNAPSHOT.jar");
        Job job = Job.getInstance(conf);

        job.setJarByClass(FofJobOne.class);

        job.setMapperClass(FofMapperOne.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setReducerClass(FofReducerOne.class);

        FileInputFormat.addInputPath(job, new Path("/fof/input/data"));

        Path outpath = new Path("/fof/output1");
        FileSystem fs = FileSystem.newInstance(conf);

        if(fs.exists(outpath)){
            fs.delete(outpath, true);
        }

        FileOutputFormat.setOutputPath(job, outpath);

        boolean flag = job.waitForCompletion(true);

        if(flag){
            System.out.println("job success!");
        }

    }
}