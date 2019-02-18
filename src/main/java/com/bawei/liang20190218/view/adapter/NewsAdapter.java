package com.bawei.liang20190218.view.adapter;

import android.app.slice.Slice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.liang20190218.R;
import com.bawei.liang20190218.model.bean.slider;
import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 09:28:16
 * @Description:
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context con;
    private ArrayList<slider> arr=new ArrayList<>();

    public NewsAdapter(Context con) {
        this.con = con;
    }
    public void setData(ArrayList<slider> list){
        if(list!=null){
            arr.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(con).inflate(R.layout.item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(arr.get(i).getTitle());
       // Glide.with(con).load("http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg").into(myViewHolder.img);
        ImageLoader.getInstance().displayImage("http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg",myViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }
    }
}
