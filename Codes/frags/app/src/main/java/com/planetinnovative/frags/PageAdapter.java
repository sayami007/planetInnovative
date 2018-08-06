package com.planetinnovative.frags;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

class PageAdapter extends FragmentPagerAdapter {

    String[] titles = {"Call", "Messsage"};

    public PageAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            CallFragment p1 = new CallFragment();
            return p1;
        } else {
            MessageFragment p2 = new MessageFragment();
            return p2;
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
