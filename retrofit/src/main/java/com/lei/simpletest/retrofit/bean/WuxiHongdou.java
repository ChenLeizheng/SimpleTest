package com.lei.simpletest.retrofit.bean;

/**
 * Created by Lei on 2018/4/10.
 */

public class WuxiHongdou {

    /**
     * PM25Out : 119
     * TempOut : 29
     * HumiOut : 23
     * PM25 : 11.1
     * Humi : 52.72
     * Temp : 23.93
     * CO2 : 561.0
     * TVOC : 0.079
     * Arofene : 0.00
     * PM10 : 30
     * Decibel : 15
     * Time : 2018-04-10 18:13:44
     */

    private String PM25Out;
    private String TempOut;
    private String HumiOut;
    private String PM25;
    private String Humi;
    private String Temp;
    private String CO2;
    private String TVOC;
    private String Arofene;
    private String PM10;
    private String Decibel;
    private String Time;

    public String getPM25Out() {
        return PM25Out;
    }

    public void setPM25Out(String PM25Out) {
        this.PM25Out = PM25Out;
    }

    public String getTempOut() {
        return TempOut;
    }

    public void setTempOut(String TempOut) {
        this.TempOut = TempOut;
    }

    public String getHumiOut() {
        return HumiOut;
    }

    public void setHumiOut(String HumiOut) {
        this.HumiOut = HumiOut;
    }

    public String getPM25() {
        return PM25;
    }

    public void setPM25(String PM25) {
        this.PM25 = PM25;
    }

    public String getHumi() {
        return Humi;
    }

    public void setHumi(String Humi) {
        this.Humi = Humi;
    }

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String Temp) {
        this.Temp = Temp;
    }

    public String getCO2() {
        return CO2;
    }

    public void setCO2(String CO2) {
        this.CO2 = CO2;
    }

    public String getTVOC() {
        return TVOC;
    }

    public void setTVOC(String TVOC) {
        this.TVOC = TVOC;
    }

    public String getArofene() {
        return Arofene;
    }

    public void setArofene(String Arofene) {
        this.Arofene = Arofene;
    }

    public String getPM10() {
        return PM10;
    }

    public void setPM10(String PM10) {
        this.PM10 = PM10;
    }

    public String getDecibel() {
        return Decibel;
    }

    public void setDecibel(String Decibel) {
        this.Decibel = Decibel;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    @Override
    public String toString() {
        return "WuxiHongdou{" +
                "PM25Out='" + PM25Out + '\'' +
                ", TempOut='" + TempOut + '\'' +
                ", HumiOut='" + HumiOut + '\'' +
                ", PM25='" + PM25 + '\'' +
                ", Humi='" + Humi + '\'' +
                ", Temp='" + Temp + '\'' +
                ", CO2='" + CO2 + '\'' +
                ", TVOC='" + TVOC + '\'' +
                ", Arofene='" + Arofene + '\'' +
                ", PM10='" + PM10 + '\'' +
                ", Decibel='" + Decibel + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
