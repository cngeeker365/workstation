package mr.itemcf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.regex.Pattern.*;

public class Step5 {
    public static void run(Configuration conf, Map<String, String> paths) {
        try {
            Job job = Job.getInstance(conf);
            job.setJobName("Step5");
            FileSystem fs = FileSystem.newInstance(conf);

            job.setJarByClass(StartRun.class);
            job.setMapperClass(Step5_Mapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            job.setReducerClass(Step5_Reducer.class);

            FileInputFormat.addInputPath(job, new Path(paths.get("Step5Input")));

            Path outpath = new Path(paths.get("Step5Output"));
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

    static class Step5_Mapper extends Mapper<LongWritable, Text, Text, Text> {
        //原封不动的输出
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //样本：   u2723   i9,8.0
            String[] tokens = compile("[\t,]").split(value.toString());
            Text k = new Text(tokens[0]);   //用户为key
            Text v = new Text(tokens[1]+","+tokens[2]);
            context.write(k, v);
        }
    }

    static class Step5_Reducer extends Reducer<Text, Text, Text,Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            Map<String, Double> r = new HashMap<>(); //结果

            for (Text value:values){// i9,4.0
                String[] tokens = value.toString().split(",");
                String itemID = tokens[0];
                Double score = Double.parseDouble(tokens[1]);
                if(r.containsKey(itemID)){
                    r.put(itemID,r.get(itemID)+score); //矩阵乘法求和计算
                }else {
                    r.put(itemID, score);
                }
            }

            Iterator<String> iter = r.keySet().iterator();
            while (iter.hasNext()){
                String itemID = iter.next();
                double score = r.get(itemID);
                Text v = new Text(itemID+","+score);
                context.write(key,v);
            }
        }
        // 样本： u13  i9,5.0
    }
}
