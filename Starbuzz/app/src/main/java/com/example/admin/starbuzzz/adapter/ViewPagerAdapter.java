package com.example.admin.starbuzzz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.starbuzzz.fragment.DrinksFragment;
import com.example.admin.starbuzzz.fragment.FoodFragment;
import com.example.admin.starbuzzz.fragment.FruitFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    //private final List<String> titlesList = new ArrayList<>();

    int numOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                FoodFragment tab1 = new FoodFragment();
                return tab1;
            case 1:
                DrinksFragment tab2 = new DrinksFragment();
                return  tab2;
            case 2:
                FruitFragment tab3 = new FruitFragment();
                return  tab3;
            default:
                return null;
        }
    }
//    public Fragment getItem(int position) {
//        return fragmentList.get(position);
//    }

    @Override
    public int getCount() {
       // return titlesList.size();
        return numOfTabs;
    }
//
//    @Override
////    public CharSequence getPageTitle(int position) {
////        return titlesList.get(position);
////    }

//    public void AddFragment(Fragment fragment, String title) {
//        fragmentList.add(fragment);
//        titlesList.add(title);
//    }
}
