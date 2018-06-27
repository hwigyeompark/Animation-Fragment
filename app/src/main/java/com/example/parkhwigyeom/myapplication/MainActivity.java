package com.example.parkhwigyeom.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Switch;
import android.widget.ViewFlipper;

import com.example.parkhwigyeom.myapplication.Fragment.a;
import com.example.parkhwigyeom.myapplication.Fragment.b;
import com.example.parkhwigyeom.myapplication.Fragment.c;
import com.example.parkhwigyeom.myapplication.Fragment.d;
import com.example.parkhwigyeom.myapplication.Fragment.e;
import com.example.parkhwigyeom.myapplication.Fragment.f;
import com.example.parkhwigyeom.myapplication.Fragment.g;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    private ViewFlipper flipper;

    Animation slide_in_right;
    Animation slide_out_left;

    Button[] Btn = new Button[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        slide_in_right = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slide_out_left = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);

        flipper = (ViewFlipper)findViewById(R.id.flipper);
        flipper.setInAnimation(slide_in_right);
        flipper.setOutAnimation(slide_out_left);
        flipper.setFlipInterval(2000);
        flipper.startFlipping();


        Btn[0] = (Button) findViewById(R.id.M);
        Btn[1] = (Button) findViewById(R.id.T);
        Btn[2] = (Button) findViewById(R.id.W);
        Btn[3] = (Button) findViewById(R.id.TH);
        Btn[4] = (Button) findViewById(R.id.F);
        Btn[5] = (Button) findViewById(R.id.S);
        Btn[6] = (Button) findViewById(R.id.SU);

        for(int i = 0; i < 7; i++) {
            Btn[i].setBackgroundColor(Color.LTGRAY);
            Btn[i].setOnClickListener(BtnOnClick);
            Btn[i].setTag(i);
        }
        Btn[0].setBackgroundColor(Color.GREEN);
    }

    View.OnClickListener BtnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int id = (int)view.getTag();

            for(int i = 0; i < 7; i++)
            {
                Btn[i].setBackgroundColor(Color.LTGRAY);
            }
            Btn[id].setBackgroundColor(Color.GREEN);
            mViewPager.setCurrentItem(id);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.a, container, false);

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new a();
                case 1:
                    return new b();
                case 2:
                    return new c();
                case 3:
                    return new d();
                case 4:
                    return new e();
                case 5:
                    return new f();
                case 6:
                    return new g();
            }
            return new a();
        }



        @Override
        public int getCount() {
            return 7;
        }
    }


}
