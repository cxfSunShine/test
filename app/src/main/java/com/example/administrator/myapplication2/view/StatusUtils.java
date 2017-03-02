package com.example.administrator.myapplication2.view;

/**
 * Created by Administrator on 2017/3/2.
 */

import android.content.Context;
import android.os.Build;
import android.view.View;

/**
 * Created by wangqi on 2016/10/16.
 */
public class StatusUtils {


    public static void initStatus(View view, Context context) {
        //判断当前版本是否大于19,,Build.VERSION_CODES.KITKAT的API版本是19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //给传递进来的View设置高度
            view.getLayoutParams().height = getAppBarHeight(context);
            //给view设置paddingTop
            view.setPadding(view.getPaddingLeft(),
                    getStatusBarHeight(context),
                    view.getPaddingRight(),
                    view.getPaddingBottom());
        }
    }

    //设置View的高度为（标题栏的高度+状态栏）的高度，这里这个56是我用来模仿标题栏的高度，想要设置高度的可以自己设置一下
    private static int getAppBarHeight(Context context) {
        return dip2px(context, 56) + getStatusBarHeight(context);
    }

    //拿到状态栏的高度
    private static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
