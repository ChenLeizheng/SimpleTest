package com.simpletest.rxjava;

/**
 * Created by Lei on 2018/4/17.
 */

public class TxtEvent {

    String text;

    public TxtEvent(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TxtEvent{" +
                "text='" + text + '\'' +
                '}';
    }
}
