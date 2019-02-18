package com.bawei.liang20190218.model.bean;

import java.util.ArrayList;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 08:59:54
 * @Description:
 */
public class extras {
    private ArrayList<slider> slider;

    @Override
    public String toString() {
        return "extras{" +
                "slider=" + slider +
                '}';
    }

    public ArrayList<com.bawei.liang20190218.model.bean.slider> getSlider() {
        return slider;
    }

    public void setSlider(ArrayList<com.bawei.liang20190218.model.bean.slider> slider) {
        this.slider = slider;
    }
}
