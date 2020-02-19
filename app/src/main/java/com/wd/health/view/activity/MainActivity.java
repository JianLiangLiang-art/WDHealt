package com.wd.health.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wd.health.R;
import com.wd.health.adapter.MyAdApter;
import com.wd.health.view.fragment.Center_fragment;
import com.wd.health.view.fragment.LeftFragment;
import com.wd.health.view.fragment.Right_fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.zhu_viewpager)
    ViewPager zhuViewpager;
    @BindView(R.id.zhu_Radiobutton_left)
    RadioButton zhuRadiobuttonLeft;
    @BindView(R.id.zhu_Radiobutton_center)
    RadioButton zhuRadiobuttonCenter;
    @BindView(R.id.zhu_Radiobutton_right)
    RadioButton zhuRadiobuttonRight;
    @BindView(R.id.zhu_Radiogroup)
    RadioGroup zhuRadiogroup;
    @BindView(R.id.ly)
    LinearLayout ly;
    private ArrayList<Fragment> flist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {
        flist = new ArrayList<>();
        flist.add(new LeftFragment());
        flist.add(new Center_fragment());
        flist.add(new Right_fragment());

        findViewById(R.id.ly).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return zhuViewpager.dispatchTouchEvent(event);
            }
        });


        MyAdApter myAdapter = new MyAdApter(getSupportFragmentManager(), flist);
        zhuViewpager.setAdapter(myAdapter);
        zhuViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                zhuRadiogroup.check(zhuRadiogroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        zhuRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.zhu_Radiobutton_left:
                        zhuViewpager.setCurrentItem(0);
                        break;
                    case R.id.zhu_Radiobutton_center:
                        zhuViewpager.setCurrentItem(1);
                        break;
                    case R.id.zhu_Radiobutton_right:
                        zhuViewpager.setCurrentItem(2);
                        break;
                }
            }
        });
        findViewById(R.id.ly).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return zhuViewpager.dispatchTouchEvent(event);
            }
        });
        zhuViewpager.setOffscreenPageLimit(3);


    }

    private long pramsstime;

    @Override
    public void onBackPressed() {
        long mills = System.currentTimeMillis();
        if (mills - pramsstime > 1000) {
            Toast.makeText(this, "再按一下退出", Toast.LENGTH_SHORT).show();
            pramsstime = System.currentTimeMillis();
            return;
        }
        // pramsstime = System.currentTimeMillis();
        // pramsstime = System.currentTimeMillis();
        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
