package mr.fof;

import mr.fof.Fof;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;

public class FofMapperOne extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] strs = StringUtils.split(value.toString(),' ');

        for(int i=0;i<strs.length;i++){
            //已知好友关系
            String s1 = Fof.format(strs[0], strs[i]);
            context.write(new Text(s1), new IntWritable(0));

            for(int j=i+1;j<strs.length;j++){
                //二度关系
                String s2 = Fof.format(strs[i], strs[j]);
                context.write(new Text(s2), new IntWritable());
            }
        }
    }
}
