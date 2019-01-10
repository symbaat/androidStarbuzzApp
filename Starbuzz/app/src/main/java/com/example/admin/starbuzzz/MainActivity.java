package com.example.admin.starbuzzz;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.admin.starbuzzz.adapter.ViewPagerAdapter;
import com.example.admin.starbuzzz.fragment.DrinksFragment;
import com.example.admin.starbuzzz.fragment.FoodFragment;
import com.example.admin.starbuzzz.fragment.FruitFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public ViewPagerAdapter viewPagerAdapter;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    FruitFragment fruitFragment;
    DrinksFragment drinksFragment;
    FoodFragment foodFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

      TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

//        tabLayout.addTab(tabLayout.newTab().setText("Foods"));
//        tabLayout.addTab(tabLayout.newTab().setText("Drinks"));
//        tabLayout.addTab(tabLayout.newTab().setText("Fruits"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

         viewPager = (ViewPager) findViewById(R.id.viewPager);
         viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("starbuzz", 0);
                StringBuilder stringBuilder = new StringBuilder();

                if (sharedPreferences.getBoolean("Damson", false)) {
                    stringBuilder.append("Damson - ");
                }
                if (sharedPreferences.getBoolean("Lychee", false)) {
                    stringBuilder.append("Lychee - ");
                }
                if (sharedPreferences.getBoolean("Mango", false)) {
                    stringBuilder.append("Mango - ");
                }
                if (sharedPreferences.getBoolean("Melon", false)) {
                    stringBuilder.append("Melon - ");
                }
                if (sharedPreferences.getBoolean("Orange", false)) {
                    stringBuilder.append("Orange - ");
                }


                if (sharedPreferences.getBoolean("Wheatgrass", false)) {
                    stringBuilder.append("Wheatgrass - ");
                }
                if (sharedPreferences.getBoolean("Grape", false)) {
                    stringBuilder.append("Grape - ");
                }
                if (sharedPreferences.getBoolean("Aloe Vera", false)) {
                    stringBuilder.append("Aloe Vera - ");
                }
                if (sharedPreferences.getBoolean("Apple", false)) {
                    stringBuilder.append("Apple - ");
                }
                if (sharedPreferences.getBoolean("Claim", false)) {
                    stringBuilder.append("Claim - ");
                }


                if (sharedPreferences.getBoolean("Banana", false)) {
                    stringBuilder.append("Banana - ");
                }
                if (sharedPreferences.getBoolean("Bilberry", false)) {
                    stringBuilder.append("Bilberry - ");
                }
                if (sharedPreferences.getBoolean("Blackberry", false)) {
                    stringBuilder.append("Blackberry - ");
                }
                if (sharedPreferences.getBoolean("Boysenberry", false)) {
                    stringBuilder.append("Boysenberry - ");
                }

                Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
