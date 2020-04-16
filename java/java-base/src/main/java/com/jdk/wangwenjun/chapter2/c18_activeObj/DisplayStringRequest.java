package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * @author taobaibai
 * @create 2020-04-16 8:48
 */
public class DisplayStringRequest extends MethodRequest {
    private final String text;

    public DisplayStringRequest(Servant servant, String text) {
        super(servant, null);
        this.text = text;
    }

    @Override
    public void execute() {
        this.servant.displayString(text);
    }
}
