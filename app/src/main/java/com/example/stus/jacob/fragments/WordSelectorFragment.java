package com.example.stus.jacob.fragments;

import com.example.stus.jacob.R;

/**
 * Created by stus on 13.05.17.
 */

public class WordSelectorFragment extends BaseFragment{
    @Override
    protected int viewID() {
        return R.layout.word_selector_fragment;
    }

    public static WordSelectorFragment getInstance(){
        return new WordSelectorFragment();
    }
}
