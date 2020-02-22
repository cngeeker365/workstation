package mr.itemcf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Map;

/**
 * 对物品组合列表进行计数，建立物品的同现矩阵
 *      i100:i100   3
 *      i100:i105   1
 *      i100:i106   1
 *      i100:i109   1
 *      i100:i114   1
 *      i100:i124   1
 */
public class Step3 {
    private final static Text K = new Text();
    private final static IntWritable V = new IntWritable(1);

    public static void run(Configuration conf, Map<String, String> paths) {
        try {
            Job job = Job.getInstance(conf);
            job.setJobName("Step3");
            FileSystem fs = FileSystem.newInstance(conf);

            job.setJarByClass(StartRun.class);
            job.setMapperClass(Step3_Mapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);
            job.setReducerClass(Step3_Reducer.class);
            job.setCombinerClass(Step3_Reducer.class);

            FileInputFormat.addInputPath(job, new Path(paths.get("Step3Input")));

            Path outpath = new Path(paths.get("Step3Output"));
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

    /**
     * 第二个 MR 执行结果 作为 本次 MR 的输入样本 ： u2837   i541:1,i331:1,i314:1,i125:1
     */
    static class Step3_Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] tokens = value.toString().split(",");
            String[] items = tokens[1].split(",");
            for(int i=0;i<items.length;i++){
                String itemA = items[i].split(":")[0];
                for(int j=0;j<items.length;j++){
                    String itemB = items[j].split(":")[0];
                    K.set(itemA+":"+itemB);
                    context.write(K,V);
                }
            }
        }
    }

    static class Step3_Reducer extends Reducer<Text, IntWritable, Text,IntWritable> {
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;

            for (IntWritable  v:values){
                sum = sum + v.get();
            }
            V.set(sum);
            context.write(key, V);
            /**
             * 执行结果：
             * i100:i181    1
             * i100:i184    2
             */
        }
    }
}
