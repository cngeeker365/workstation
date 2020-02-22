package mr.weather;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TQReducer extends Reducer<Weather, IntWritable, Text, NullWritable> {
    @Override
    protected void reduce(Weather key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int flag = 0;
        for (IntWritable i: values){
            flag ++;
            if(flag>2){
                break;
            }
            String msg = key.getYear()+"-"+key.getMonth()+"-"+key.getDay()+"-"+i.get();
            context.write(new Text(msg), NullWritable.get());
        }
    }
}
