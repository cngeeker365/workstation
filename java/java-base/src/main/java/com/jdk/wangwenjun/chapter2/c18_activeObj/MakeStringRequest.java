package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * {@link ActiveObject#makeString(int, char)}
 * @author taobaibai
 * @create 2020-04-16 8:44
 */
public class MakeStringRequest extends MethodRequest {
    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
