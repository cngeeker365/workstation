package mr.itemcf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Map;

public class Step1 {
    public static void run(Configuration conf, Map<String, String> paths) {
        try {
            Job job = Job.getInstance(conf);
            job.setJobName("Step1");
            FileSystem fs = FileSystem.newInstance(conf);

            job.setJarByClass(StartRun.class);
            job.setMapperClass(Step1_Mapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(NullWritable.class);
            job.setReducerClass(Step1_Reducer.class);

            FileInputFormat.addInputPath(job, new Path(paths.get("Step1Input")));

            Path outpath = new Path(paths.get("Step1Output"));
            if(fs.exists(outpath)){
                fs.delete(outpath,true);
            }
            FileOutputFormat.setOutputPath(job, outpath);

            boolean flag = job.waitForCompletion(true);

            if(flag){
                System.out.println("job success!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Step1_Mapper extends Mapper<LongWritable, Text, Text, NullWritable>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            if(key.get()!=0){
                context.write(value, NullWritable.get());
            }
        }
    }

    static class Step1_Reducer extends Reducer<Text, IntWritable, Text,NullWritable>{
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            context.write(key, NullWritable.get());
        }
    }
}
