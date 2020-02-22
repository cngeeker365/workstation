package mr.pageRank;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * 将字符串转换为 Node 对象 字符串  :0.5    B   D
 */
public class Node {
    //字符串第一个元素初始PR值为 1
    private double pageRank = 1.0;

    //字符串中 后面的节点列表 数组
    private String[] adjacentNodeNames;

    //PR值 与 数组的分隔符 \t
    public static final char fieldSeparator='\t';

    public double getPageRank() {
        return pageRank;
    }

    public Node setPageRank(double pageRank) {
        this.pageRank = pageRank;
        return this;
    }

    public String[] getAdjacentNodeNames() {
        return adjacentNodeNames;
    }

    public Node setAdjacentNodeNames(String[] adjacentNodeNames) {
        this.adjacentNodeNames = adjacentNodeNames;
        return this;
    }

    public static char getFieldSeparator() {
        return fieldSeparator;
    }

    public boolean containsAdjacentNodes(){
        return adjacentNodeNames != null && adjacentNodeNames.length>0;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(pageRank);

       if(getAdjacentNodeNames()!=null){
           sb.append(fieldSeparator).append(StringUtils.join(getAdjacentNodeNames(),fieldSeparator));
       }
       return sb.toString();
    }

    //value =1.0    B   D
    public static Node fromMR(String value) throws IOException{
        String[] parts = StringUtils.splitPreserveAllTokens(value, fieldSeparator);
        if (parts.length<1){
            throw new IOException("Expected 1 or more parts but received "+parts.length);
        }
        //1.0   A   B   D
        Node node = new Node().setPageRank(Double.valueOf(parts[0]));
        if (parts.length>1){
            node.setAdjacentNodeNames(Arrays.copyOfRange(parts, 1, parts.length));
        }
        return node;
    }
}
