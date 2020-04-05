package hbase.wc;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class WCTableReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable> {

    public static final byte[] CF = "cf".getBytes();
    public static final byte[] COUNT = "count".getBytes();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum =0;
        for(IntWritable i : values){
            sum += i.get();
        }
        Put put = new Put(Bytes.toBytes(key.toString()));
        put.addColumn(CF, COUNT, Bytes.toBytes(sum));
        context.write(null, put);
    }
}
