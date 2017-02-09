package bwie.project;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by 荆泽阳 on 2017/2/9.
 * .::::.
 * .::::::::.
 * :::::::::::  Goddess bless, never bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */
public class Myadapter extends PagerAdapter {
    private String[] path;
    private Context context;
    private BitmapUtils bitmapUtils;

    public Myadapter(String[] path, Context context) {
        super();
        this.path = path;
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return path.length;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        ImageView imageView = new ImageView(context);
        bitmapUtils.display(imageView, path[position]);
        container.addView(imageView);

        return imageView;
    }


}
