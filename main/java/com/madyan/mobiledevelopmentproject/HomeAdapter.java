package com.madyan.mobiledevelopmentproject;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeAdapter extends FragmentPagerAdapter
{
    private Context context;
    int totalTabs;

    public HomeAdapter(FragmentManager fm, Context context, int totalTabs)
    {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int fragment)
    {
        switch (fragment)
        {
            case 0:
                ChairTabFragment chairTabFragment = new ChairTabFragment();
                return chairTabFragment;
            case 1:
                DeskTabFragment deskTabFragment = new DeskTabFragment();
                return deskTabFragment;
            case 2:
                ShelfTabFragment shelfTabFragment = new ShelfTabFragment();
                return shelfTabFragment;
            case 3:
                BedTabFragment bedTabFragment = new BedTabFragment();
                return bedTabFragment;
            default:
                return null;
        }
    }
}
