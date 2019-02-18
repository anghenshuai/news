package com.bawei.liang20190218.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.liang20190218.R;
import com.bawei.liang20190218.model.bean.JsonBean;
import com.bawei.liang20190218.presenter.MainPresenter;
import com.bawei.liang20190218.view.adapter.NewsAdapter;
import com.bawei.liang20190218.view.interfaces.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView {

    private RecyclerView view;
    private String path="http://365jia.cn/news/api3/365jia/news/headline?page=1";
    private MainPresenter mainPresenter;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        loadhttp();
    }

    private void initView() {
        view = findViewById(R.id.view);
    }

    private void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        view.setLayoutManager(linearLayoutManager);
        adapter = new NewsAdapter(this);
        view.setAdapter(adapter);
    }

    private void loadhttp() {
        mainPresenter.getHomeData(path);
    }

    @Override
    public void callBackData(JsonBean jsonBean) {
        adapter.setData(jsonBean.getData().getExtras().getSlider());
    }
    //防止内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.desthView();
    }
}
