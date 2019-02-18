package com.bawei.liang20190218.model.bean;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 09:00:16
 * @Description:
 */
public class slider {
    private String title;

    @Override
    public String toString() {
        return "slider{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
