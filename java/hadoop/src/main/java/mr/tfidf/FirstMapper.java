package mr.tfidf;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.io.StringReader;

public class FirstMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] v = value.toString().trim().split("\t");
        if(v.length >= 2){
            String id = v[0].trim();
            String content = v[1].trim();

            /**
             * 该部分注释掉，因为懒得找 IKSegmenter 的依赖包
             *
            StringReader sr = new StringReader(content);
            IKSegmenter ikSegmenter = new IKSegmenter(sr, true);    //分词器
            Lexeme word = null;
            while((word = ikSegmenter.next()) != null){
                String w = word.getLexemeText();    //分词
                context.write(new Text(w+"_"+id), new IntWritable(1));
            }
             */
            context.write(new Text("count"), new IntWritable(1));   //用于统计行数
        }else{
            System.out.println(value.toString()+"--------------------");
        }
    }
}
