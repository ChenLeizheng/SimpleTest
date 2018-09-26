package com.lei.simpletest.retrofit.bean;

/**
 * Created by Lei on 2017/12/30.
 */

public class Yinchaun {

    /**
     * co2 : 641.0
     * humidity : 43.44
     * pm25 : 7.6
     * temp : 25.86
     * voc : 0.105
     * pm25Out : 44
     * tempOut : 1
     * humiOut : 16
     * date : 2017-12-30 17:52:05
     */

    private double co2;
    private double humidity;
    private double pm25;
    private double temp;
    private double voc;
    private String pm25Out;
    private String tempOut;
    private String humiOut;
    private String date;

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getVoc() {
        return voc;
    }

    public void setVoc(double voc) {
        this.voc = voc;
    }

    public String getPm25Out() {
        return pm25Out;
    }

    public void setPm25Out(String pm25Out) {
        this.pm25Out = pm25Out;
    }

    public String getTempOut() {
        return tempOut;
    }

    public void setTempOut(String tempOut) {
        this.tempOut = tempOut;
    }

    public String getHumiOut() {
        return humiOut;
    }

    public void setHumiOut(String humiOut) {
        this.humiOut = humiOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Yinchaun{" +
                "co2=" + co2 +
                ", humidity=" + humidity +
                ", pm25=" + pm25 +
                ", temp=" + temp +
                ", voc=" + voc +
                ", pm25Out='" + pm25Out + '\'' +
                ", tempOut='" + tempOut + '\'' +
                ", humiOut='" + humiOut + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
