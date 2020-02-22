package mr.pageRank;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class RunJob {

    public static enum Mycounter{
        //枚举
        my
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //默认加载src 下的配置文件
        Configuration conf = new Configuration();
        conf.set("mapreduce.app-submission.cross-platform", "true");    //跨平台提交
        conf.set("mapred.jar","F:\\workstation\\java\\hadoop\\target\\hadoop-1.0-SNAPSHOT.jar");


        //  收敛值
        double d = 0.001;
        //  循环计算次数
        int i = 0;

        while(true){
            //记录计算的次数
            conf.setInt("runCount",i);

            Job job = Job.getInstance(conf);
            FileSystem fs = FileSystem.newInstance(conf);

            job.setJarByClass(RunJob.class);
            job.setMapperClass(PageRankMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            job.setReducerClass(PageRankReducer.class);
            job.setInputFormatClass(KeyValueTextInputFormat.class); //该类用制表符切割后，将第一个作为key，后续的作为value

            Path inputPath = new Path("/pagerank/input/pr");
            if(i>1){
                inputPath = new Path("/pagerank/output/pr"+(i-1));
            }
            FileInputFormat.addInputPath(job, inputPath);

            Path outpath = new Path("/pagerank/output/pr"+i);
            if(fs.exists(outpath)){
                fs.delete(outpath,true);
            }
            FileOutputFormat.setOutputPath(job, outpath);

            boolean flag = job.waitForCompletion(true);

            if(flag){
                System.out.println("job success!");

                //获取计数器中的差值
                long sum = job.getCounters().findCounter(Mycounter.my).getValue();

                System.out.println("SUM: "+sum);
                double avgd = sum / 4000.0;  //四个页面，计算差值时扩大了1000倍
                if (avgd < d) {
                    break;
                }
            }
        }
    }
}
