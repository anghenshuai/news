package com.bawei.liang20190218.presenter;

import android.view.View;

import com.bawei.liang20190218.view.interfaces.IBaseView;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 08:49:16
 * @Description:
 */
public class BasePresenter<V extends IBaseView>{
    private V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }
    public void desthView(){
        this.view=null;
    }
}
