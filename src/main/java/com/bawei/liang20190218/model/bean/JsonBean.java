package com.bawei.liang20190218.model.bean;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 08:59:33
 * @Description:
 */
public class JsonBean {
    private data data;

    @Override
    public String toString() {
        return "JsonBean{" +
                "data=" + data +
                '}';
    }

    public com.bawei.liang20190218.model.bean.data getData() {
        return data;
    }

    public void setData(com.bawei.liang20190218.model.bean.data data) {
        this.data = data;
    }
}
