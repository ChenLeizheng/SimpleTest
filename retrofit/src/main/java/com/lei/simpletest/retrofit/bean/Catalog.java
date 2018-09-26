package com.lei.simpletest.retrofit.bean;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei on 2018/7/20.
 * @Root(strict = false) @注解(不严格检查)
 * inline表示是否内联，entry表示每个子元素的标签名字，required表示是否为必须标签required属性设置false说明当前属性是可空的
 */
@Root(name = "CATALOG",strict = false)
public class Catalog {

    @ElementList(inline = true, entry = "CD", required = false)
    public List<Cd> cdList;

    public List<Cd> getCdList() {
        if (cdList == null) {
            return new ArrayList<>();
        }
        return cdList;
    }

    public void setCdList(List<Cd> cdList) {
        this.cdList = cdList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "cdList=" + cdList +
                '}';
    }
}
