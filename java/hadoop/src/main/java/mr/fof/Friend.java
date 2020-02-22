package mr.fof;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Friend implements WritableComparable<Friend> {

    private String friend1;
    private String friend2;
    //亲密度
    private int hot;

    @Override
    public int compareTo(Friend o) {
        int c = this.friend1.compareTo(o.getFriend1());

        if(c==0){
            return Integer.compare(this.hot, o.getHot());
        }

        return c;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(friend1);
        dataOutput.writeUTF(friend2);
        dataOutput.writeInt(hot);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.friend1 = dataInput.readUTF();
        this.friend2 = dataInput.readUTF();
        this.hot = dataInput.readInt();
    }

    public String getFriend1() {
        return friend1;
    }

    public void setFriend1(String friend1) {
        this.friend1 = friend1;
    }

    public String getFriend2() {
        return friend2;
    }

    public void setFriend2(String friend2) {
        this.friend2 = friend2;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
}
