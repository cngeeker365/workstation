package mr.fof;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FofReducerOne extends Reducer<Text, IntWritable, Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //亲密度
        int sum = 0;
        boolean flag = true;

        for(IntWritable i:values){
            if(i.get() == 0){
                //有0就说明二者已经确认了好友关系
                flag = false;
                break;
            }
            sum += i.get();
        }
        if(flag){
            String msg = key.toString()+"-"+sum;
            context.write(new Text(msg), NullWritable.get());
        }
    }
}
