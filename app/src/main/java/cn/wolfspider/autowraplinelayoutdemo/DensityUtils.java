package cn.wolfspider.autowraplinelayoutdemo;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;

public class DensityUtils {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dpToPx(Context context, float dpValue) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, displayMetrics);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int pxToDp(Context context, float pxValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / density);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int spToPx(Context context, float spValue) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, displayMetrics));
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int pxToSp(Context context, float pxValue) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scaledDensity);
    }

    /**
     *  得到屏幕的宽和高
     *  @return 返回大小为2的整数类型数组, 下标为0的表示宽, 下标为1的表示高
     */
    public static int[] getScreenWidthAndHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int[] size = new int[2];
        size[0] = displayMetrics.widthPixels;
        size[1] = displayMetrics.heightPixels;
        return size;
    }

    /**
     * 得到状态栏的高度
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 得到标题栏的高度
     * note: 该方法必须在页面完全显示出来时调用, 否则返回0
     */
    public static int getTitleBarHeight(Context context) {
        int height = ((Activity)context).getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        if (height == 0) {
            return 0;
        }
        return height - getStatusBarHeight(context);
    }

    /**
     * 得到App的高度
     * note: 该方法必须在页面完全显示出来时调用, 否则返回0
     */
    public static int getAppHeight(Context context) {
        return ((Activity)context).getWindow().findViewById(Window.ID_ANDROID_CONTENT).getMeasuredHeight();
       }
}
