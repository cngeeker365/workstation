package mr.tfidf;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class FirstPartition extends HashPartitioner<Text, IntWritable> {
    @Override
    public int getPartition(Text key, IntWritable value, int numReduceTasks) {
        //将行数统计分配到最后一个reduce任务上
        if(key.equals(new Text("count"))) {
            return 3;
        }else {
            //将其他任务分配到除最后一个reduce任务上
            return super.getPartition(key, value, numReduceTasks - 1);
        }
    }
}
