package mr.weather;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.lang.Integer;

public class Weather implements WritableComparable<Weather> {
    private int year;
    private int month;
    private int day;
    private int wd; //温度

    /**
     * 何时调用？
     * 1）比较两个Weather对象
     * 2）没有重写Sort和Group，排序分组也会调用
     */
    @Override
    public int compareTo(Weather o) {
        int c1 = Integer.compare(this.year, o.getYear());
        if (c1==0){
            int c2 = Integer.compare(this.month, o.getMonth());
            if (c2 == 0){
                return Integer.compare(this.wd, o.getWd());
            }
        }
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(year);
        dataOutput.writeInt(month);
        dataOutput.writeInt(day);
        dataOutput.writeInt(wd);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.year = dataInput.readInt();
        this.month = dataInput.readInt();
        this.day = dataInput.readInt();
        this.wd = dataInput.readInt();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWd() {
        return wd;
    }

    public void setWd(int wd) {
        this.wd = wd;
    }
}
