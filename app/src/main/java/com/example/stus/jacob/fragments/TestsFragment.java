package com.example.stus.jacob.fragments;

import com.example.stus.jacob.R;

/**
 * Created by stus on 14.05.17.
 */

public class TestsFragment extends BaseFragment {
    @Override
    protected int viewID() {
        return R.layout.test_fragment;
    }

    public static BaseFragment getInstance() {
        return new TestsFragment();
    }

    @Override
    protected Initer getInit() {
        return super.getInit().add(this::init);
    }

    private void init() {
        //// TODO: 14.05.17 make Test api
    }
}
