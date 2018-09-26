package com.lei.bindview;

/**
 * Created by Lei on 2018/2/7.
 */

public class Progress {
    float value;
    float minValue;
    float maxValue;
    int color;
    String levelText;

    public Progress(float value, float minValue, float maxValue, int color, String levelText) {
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.color = color;
        this.levelText = levelText;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "value=" + value +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", color=" + color +
                ", levelText='" + levelText + '\'' +
                '}';
    }
}
