package mr.fof;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FofSort extends WritableComparator {
    protected FofSort() {
        super(Friend.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        Friend f1 = (Friend)a;
        Friend f2 = (Friend)b;

        int c = f1.getFriend1().compareTo(f2.getFriend1());

        if(c==0){
            //亲密度降序排序
            return -Integer.compare(f1.getHot(), f2.getHot());
        }
        return c;
    }
}
