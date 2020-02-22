package mr.fof;

public class Fof {
    public static String format(String f1, String f2){
        int c = f1.compareTo(f2);
        if (c<0){
            return f2+"-"+f1;
        }
        return f1+"-"+f2;
    }
}
