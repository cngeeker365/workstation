package hbase.wc;

import mr.weather.TQMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WCJob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //默认加载src 下的配置文件
        Configuration conf = new Configuration();
        conf.set("mapreduce.app-submission.cross-platform", "true");    //跨平台提交
        conf.set("mapred.jar","F:\\workstation\\java\\hadoop\\target\\hadoop-1.0-SNAPSHOT.jar");
        conf.set("hbase.zookeeper.quorum", "n1,n2,n3");
        Job job = Job.getInstance(conf);

        job.setJarByClass(WCJob.class);

        job.setMapperClass(WCMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path("/wc/input/YouHaveOnlyOneLife"));

        //hbase reducer
        String targetTable = "wc";
        TableMapReduceUtil.initTableReducerJob(
                targetTable,    // reduce 输出到哪一张表
                WCTableReducer.class, //reducer class
                job
        );

        boolean flag = job.waitForCompletion(true);

        if(flag){
            System.out.println("job success!");
        }

    }
}
