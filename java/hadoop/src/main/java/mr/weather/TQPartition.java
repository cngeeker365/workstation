package mr.weather;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class TQPartition extends HashPartitioner<Weather, IntWritable> {

    @Override
    public int getPartition(Weather key, IntWritable value, int numReduceTasks) {
        /**
         * 重写Partition的规则：
         *  1）满足业务要求
         *  2）越简单越好
         */
        return (key.getYear()-1949) % numReduceTasks;
    }
}
