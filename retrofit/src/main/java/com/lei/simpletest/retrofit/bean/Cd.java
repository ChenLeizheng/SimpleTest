package com.lei.simpletest.retrofit.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Lei on 2018/7/20.
 */
@Root(name = "CD",strict = false)
public class Cd {
    @Element(name = "TITLE")
    String title;
    @Element(name = "ARTIST")
    String artist;
    @Element(name = "COUNTRY")
    String country;
    @Element(name = "PRICE")
    String price;
    @Element(name = "YEAR")
    String year;

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist == null ? "" : artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country == null ? "" : country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price == null ? "" : price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year == null ? "" : year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", country='" + country + '\'' +
                ", price='" + price + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
