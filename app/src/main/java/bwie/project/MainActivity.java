package bwie.project;

import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private LinearLayout fl;
    private
    String[] path = new String[]{
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-214476.jpg/168",
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-214267.jpg/168",
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-214269.jpg/168",
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-214521.jpg/168",
            "http://zxpic.gtimg.com/infonew/0/wechat_pics_-214479.jpg/168"};
    private List<ImageView> list;
    private int index;
    private Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                //获取当前的页数
                int currentItem = viewpager.getCurrentItem();
                currentItem++;
                viewpager.setCurrentItem(currentItem);
                handler.sendEmptyMessageDelayed(0,1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        fl = (LinearLayout) findViewById(R.id.fl);
        addpoint();
        viewpager.setAdapter(new Myadapter(path, this));
        viewpager.setCurrentItem(path.length*100000);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub

                View current = fl.getChildAt(arg0);
                current.setEnabled(false);

                View view = fl.getChildAt(index);
                view.setEnabled(true);
                index = arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        handler.sendEmptyMessageDelayed(0,1000);

    }

    private void addpoint() {
        list = new ArrayList<>();
        for (int i = 0; i < path.length; i++) {
            ImageView imager = new ImageView(this);
            imager.setBackgroundResource(R.drawable.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 15;
            imager.setLayoutParams(layoutParams);
            if (i == 0) {

                imager.setEnabled(false);

            }
            fl.addView(imager);
        }


    }
}
