package mr.tfidf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FirstJob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //默认加载src 下的配置文件
        Configuration conf = new Configuration();
//        conf.set("fs.defaultFs", "hdfs://n1:8020");
//        conf.set("yarn.resourcemanager.hostname","n3");
        conf.set("mapreduce.app-submission.cross-platform", "true");    //跨平台提交
        conf.set("mapred.jar","F:\\workstation\\java\\hadoop\\target\\hadoop-1.0-SNAPSHOT.jar");

        FileSystem fs = FileSystem.newInstance(conf);

        Job job = Job.getInstance(conf);
        job.setJarByClass(FirstJob.class);
        job.setJobName("weibo1");

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setNumReduceTasks(4);
        job.setPartitionerClass(FirstPartition.class);
        job.setMapperClass(FirstMapper.class);
        job.setCombinerClass(FirstReduce.class);
        job.setReducerClass(FirstReduce.class);

        FileInputFormat.addInputPath(job, new Path("/user/tfidf/input"));

        Path outpath = new Path("/user/tfidf/output/weibo1");

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
