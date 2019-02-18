package com.bawei.liang20190218.model.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.bawei.liang20190218.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @Auther: L丶Ang
 * @Date: 2019/2/18 09:56:17
 * @Description:
 */
public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions displayImageOptions=new DisplayImageOptions.Builder()
                .showImageOnFail(R.mipmap.shibai)
                .showImageOnLoading(R.mipmap.zhan)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
        ImageLoaderConfiguration imageLoaderConfiguration=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(imageLoaderConfiguration);
    }
}
