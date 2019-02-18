package com.bawei.liang20190218.model.bean;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 09:05:24
 * @Description:
 */
public class data {
    private extras extras;

    @Override
    public String toString() {
        return "data{" +
                "extras=" + extras +
                '}';
    }

    public com.bawei.liang20190218.model.bean.extras getExtras() {
        return extras;
    }

    public void setExtras(com.bawei.liang20190218.model.bean.extras extras) {
        this.extras = extras;
    }
}
