package com.example.stus.jacob.fragments;

import com.example.stus.jacob.R;

/**
 * Created by stus on 13.05.17.
 */

public class SubtitliesFragment extends BaseFragment {
    @Override
    protected int viewID() {
        return R.layout.subtitles_fragment;
    }

    public static SubtitliesFragment getInstance() {
        return new SubtitliesFragment();
    }

}

