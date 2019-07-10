package com.example.user.shedule2v2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.user.shedule2v2.Tab1Fragment.Items2w;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    public Button button;

    public int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Starting.");

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), ded.kogdaded(), Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        floatingActionButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);

                return false;
            }
        });

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(1);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.switch1);

        //DATE

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("D");
        final int weekday = Integer.parseInt(formatForDateNow.format(date));


        formatForDateNow = new SimpleDateFormat("w");
        int weeknum = Integer.parseInt(formatForDateNow.format(date));
        weeknum=weeknum-5;

        //switchCompat.setText(Integer.toString(weeknum)+" неделя "+Integer.toString(weekday%7)+"день");
        switchCompat.setText(Integer.toString(weeknum)+" неделя");
        if (weeknum % 2 == 0){
            switchCompat.setChecked(true);
        }else{
            switchCompat.setChecked(false);
        }
        if (weekday%7>0 && weekday%7<=5){
            mViewPager.setCurrentItem(weekday%7-1);
//            mViewPager.post(new Runnable() {
//                @Override
//                public void run() {
//                    mViewPager.setCurrentItem(weekday%7);
//                }
//            });
        }


        //ENDDATE


        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.container + ":" + mViewPager.getCurrentItem());
                Fragment page0 = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.container + ":" + (mViewPager.getCurrentItem()-1));
                Fragment page1 = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.container + ":" + (mViewPager.getCurrentItem()+1));

                int podgon = mViewPager.getCurrentItem();

                TextView testtext;

                int[] Images = {R.drawable.para1, R.drawable.para2, R.drawable.para3, R.drawable.para4, R.drawable.para5, R.drawable.para6, R.drawable.para7};
                RecyclerView recyclerView1;
                RecyclerView recyclerView2;
                RecyclerView recyclerView3;
                RecyclerView recyclerView4;
                RecyclerView recyclerView5;

                switch (podgon) {
                    case 0:
                        recyclerView1 = (RecyclerView) page.getView().findViewById(R.id.recyclerview1);
                        recyclerView2 = (RecyclerView) page1.getView().findViewById(R.id.recyclerview2);
                        if (isChecked){
                            recyclerView1.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab1Fragment.Items1w, Tab1Fragment.Items2w, Images));
                            recyclerView2.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab2Fragment.Items1w, Tab2Fragment.Items2w, Images));
                        }else{
                            recyclerView1.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab1Fragment.Items1, Tab1Fragment.Items2, Images));
                            recyclerView2.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab2Fragment.Items1, Tab2Fragment.Items2, Images));
                        }
                        break;
                    case 1:
                        recyclerView1 = (RecyclerView) page0.getView().findViewById(R.id.recyclerview1);
                        recyclerView2 = (RecyclerView) page.getView().findViewById(R.id.recyclerview2);
                        recyclerView3 = (RecyclerView) page1.getView().findViewById(R.id.recyclerview3);
                        if (isChecked){
                            recyclerView1.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab1Fragment.Items1w, Tab1Fragment.Items2w, Images));
                            recyclerView2.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab2Fragment.Items1w, Tab2Fragment.Items2w, Images));
                            recyclerView3.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab3Fragment.Items1w, Tab3Fragment.Items2w, Images));
                        }else{
                            recyclerView1.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab1Fragment.Items1, Tab1Fragment.Items2, Images));
                            recyclerView2.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab2Fragment.Items1, Tab2Fragment.Items2, Images));
                            recyclerView3.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab3Fragment.Items1, Tab3Fragment.Items2, Images));
                        }
                        break;
                    case 2:
                        recyclerView2 = (RecyclerView) page0.getView().findViewById(R.id.recyclerview2);
                        recyclerView3 = (RecyclerView) page.getView().findViewById(R.id.recyclerview3);
                        recyclerView4 = (RecyclerView) page1.getView().findViewById(R.id.recyclerview4);
                        if (isChecked){
                            recyclerView2.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab2Fragment.Items1w, Tab2Fragment.Items2w, Images));
                            recyclerView3.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab3Fragment.Items1w, Tab3Fragment.Items2w, Images));
                            recyclerView4.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab4Fragment.Items1w, Tab4Fragment.Items2w, Images));
                        }else{
                            recyclerView2.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab2Fragment.Items1, Tab2Fragment.Items2, Images));
                            recyclerView3.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab3Fragment.Items1, Tab3Fragment.Items2, Images));
                            recyclerView4.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab4Fragment.Items1, Tab4Fragment.Items2, Images));
                        }
                        break;
                    case 3:
                        recyclerView3 = (RecyclerView) page0.getView().findViewById(R.id.recyclerview3);
                        recyclerView4 = (RecyclerView) page.getView().findViewById(R.id.recyclerview4);
                        recyclerView5 = (RecyclerView) page1.getView().findViewById(R.id.recyclerview5);
                        if (isChecked){
                            recyclerView3.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab3Fragment.Items1w, Tab3Fragment.Items2w, Images));
                            recyclerView4.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab4Fragment.Items1w, Tab4Fragment.Items2w, Images));
                            recyclerView5.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab5Fragment.Items1w, Tab5Fragment.Items2w, Images));
                        }else{
                            recyclerView3.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab3Fragment.Items1, Tab3Fragment.Items2, Images));
                            recyclerView4.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab4Fragment.Items1, Tab4Fragment.Items2, Images));
                            recyclerView5.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab5Fragment.Items1, Tab5Fragment.Items2, Images));
                        }
                        break;
                    case 4:
                        recyclerView4 = (RecyclerView) page0.getView().findViewById(R.id.recyclerview4);
                        recyclerView5 = (RecyclerView) page.getView().findViewById(R.id.recyclerview5);
                        if (isChecked){
                            recyclerView4.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab4Fragment.Items1w, Tab4Fragment.Items2w, Images));
                            recyclerView5.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab5Fragment.Items1w, Tab5Fragment.Items2w, Images));
                        }else{
                            recyclerView4.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab4Fragment.Items1, Tab4Fragment.Items2, Images));
                            recyclerView5.setAdapter(new RecyclerViewAdapter(MainActivity.this, Tab5Fragment.Items1, Tab5Fragment.Items2, Images));
                        }
                        break;
                }


            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), getString(R.string.tab_text_1));
        adapter.addFragment(new Tab2Fragment(), getString(R.string.tab_text_2));
        adapter.addFragment(new Tab3Fragment(), getString(R.string.tab_text_3));
        adapter.addFragment(new Tab4Fragment(), getString(R.string.tab_text_4));
        adapter.addFragment(new Tab5Fragment(), getString(R.string.tab_text_5));
        viewPager.setAdapter(adapter);
    }

}
