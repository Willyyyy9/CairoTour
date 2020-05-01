package com.example.cairotour;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;


    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //Knowing which fragment will get loaded
        if (position == 0) {
            return new CafeFragment();
        } else if (position == 1) {
            return new HistoricalFragment();
        } else if (position == 2) {
            return new PhrasesFragment();
        } else {
            return new TipsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Knowing which title will be put
        if (position == 0) {
            return mContext.getString(R.string.category_cafe);
        } else if (position == 1) {
            return mContext.getString(R.string.category_historical);
        } else if (position == 2) {
            return mContext.getString(R.string.category_phrases);
        } else {
            return mContext.getString(R.string.category_tips);
        }
    }
}
