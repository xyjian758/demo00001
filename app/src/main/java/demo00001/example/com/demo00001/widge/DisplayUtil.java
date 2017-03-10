package demo00001.example.com.demo00001.widge;

import android.content.Context;

/**
 * @作者 Ray
 * @创建时间 2016/7/18 14:52
 * @描述 ${TODO}
 * @修订 ${Author}
 * @修订时间 2016/7/18
 * @修订描述 ${TODO}
 */
public class DisplayUtil {

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * dp转换成px
     */
    private  static int dip2px(Context context,int dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale);

    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
