package com.randomappsinc.studentpicker.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.randomappsinc.studentpicker.R;
import com.randomappsinc.studentpicker.activities.MainActivity;
import com.randomappsinc.studentpicker.fragments.EditNameListFragment;
import com.randomappsinc.studentpicker.fragments.NameChoosingFragment;
import com.randomappsinc.studentpicker.utils.MyApplication;

public class ListTabsAdapter extends FragmentStatePagerAdapter {

    private NameChoosingFragment nameChoosingFragment;
    private Fragment editNameListFragment;
    private String tabTitles[];
    private String listName;

    public ListTabsAdapter(FragmentManager fragmentManager, String listName) {
        super(fragmentManager);
        this.tabTitles = MyApplication.getAppContext().getResources().getStringArray(R.array.list_options);
        this.listName = listName;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.LIST_NAME_KEY, listName);
        switch (position) {
            case 0:
                if (nameChoosingFragment == null) {
                    nameChoosingFragment = new NameChoosingFragment();
                    nameChoosingFragment.setArguments(bundle);
                }
                return nameChoosingFragment;
            case 1:
                if (editNameListFragment == null) {
                    editNameListFragment = new EditNameListFragment();
                    editNameListFragment.setArguments(bundle);
                }
                return editNameListFragment;
            default:
                return null;
        }
    }

    public NameChoosingFragment getNameChoosingFragment() {
        return nameChoosingFragment;
    }

    public Fragment getEditNameListFragment() {
        return editNameListFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}