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
import java.util.HashMap;
import java.util.Map;

public class Step2 {
    public static void run(Configuration conf, Map<String, String> paths) {
        try {
            Job job = Job.getInstance(conf);
            job.setJobName("Step2");
            FileSystem fs = FileSystem.newInstance(conf);

            job.setJarByClass(StartRun.class);
            job.setMapperClass(Step2_Mapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            job.setReducerClass(Step2_Reducer.class);

            FileInputFormat.addInputPath(job, new Path(paths.get("Step2Input")));

            Path outpath = new Path(paths.get("Step2Output"));
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

    static class Step2_Mapper extends Mapper<LongWritable, Text, Text, Text> {
        //如果使用：用户+物品，同时作为输出key，更好
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] tokens = value.toString().split(",");
            String item = tokens[0];
            String user = tokens[1];
            String action = tokens[2];
            Text k = new Text(user);
            Integer rv = StartRun.R.get(action);
            Text v = new Text(item+":"+rv.intValue());
            context.write(k, v);
        }
    }

    static class Step2_Reducer extends Reducer<Text, Text, Text,Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            Map<String, Integer> r = new HashMap<>();

            for (Text value:values){
                String[] vs = value.toString().split(":");
                String item = vs[0];
                Integer action = Integer.parseInt(vs[1]);
                action = ((Integer)(r.get(item)==null?0:r.get(item))).intValue()+action;
                r.put(item, action);
            }
            StringBuffer sb = new StringBuffer();
            for(Map.Entry<String, Integer> entry:r.entrySet()){
                sb.append(entry.getKey()+":"+entry.getValue().intValue()+",");
            }
            context.write(key, new Text(sb.toString()));
        }
    }
}
