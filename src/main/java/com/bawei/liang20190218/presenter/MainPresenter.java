package com.bawei.liang20190218.presenter;

import com.bawei.liang20190218.model.bean.JsonBean;
import com.bawei.liang20190218.model.util.HttpUtils;
import com.bawei.liang20190218.view.interfaces.IMainView;

import java.io.IOException;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 08:49:06
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView> implements HttpUtils.CallBackData<JsonBean> {

    private final HttpUtils httpUtils;

    public MainPresenter(){
        httpUtils = HttpUtils.getInstance();
        httpUtils.setCallBackData(this);
    }
    public void getHomeData(String path){
        httpUtils.getData(path, JsonBean.class);
    }

    @Override
    public void Err(IOException e) {

    }

    @Override
    public void Sueesmea(JsonBean o) {
        getView().callBackData(o);
    }
}
