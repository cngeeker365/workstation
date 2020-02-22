package mr.pageRank;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PageRankMapper extends Mapper<Text,Text,Text, Text> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        int runCount = context.getConfiguration().getInt("runCount",1);
        //A     B     D
        String page = key.toString();
        Node node = null;
        if(runCount==1){
            node = Node.fromMR("1.0"+"\t"+value.toString());
        }else {
            node = Node.fromMR(value.toString());
        }
        //A:1.0     B   D
        //将计算前的数据输出 reduce 计算做差值
        context.write(new Text(page), new Text(node.toString()));

        if(node.containsAdjacentNodes()){
            double outValue = node.getPageRank() / node.getAdjacentNodeNames().length;
            for(int i=0; i<node.getAdjacentNodeNames().length;i++){
                String outPage = node.getAdjacentNodeNames()[i];
                // B: 0.5
                // D: 0.5
                context.write(new Text(outPage), new Text(outValue+""));
            }
        }
    }
}
