package com.example.stus.jacob.fragments;

import com.example.stus.jacob.R;

/**
 * Created by stus on 13.05.17.
 */

public class TempFragment extends BaseFragment {
    @Override
    protected int viewID() {
        return R.layout.search;
    }

    public static TempFragment getInstance(){
        return new TempFragment();
    }
}
