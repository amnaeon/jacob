package com.example.stus.jacob.fragments;

import com.example.stus.jacob.R;

/**
 * Created by stus on 14.05.17.
 */

public class WordSendFragment extends BaseFragment {
    @Override
    protected int viewID() {
        return R.layout.subtitles_send;
    }

    public static WordSendFragment getInstance(){
        return new WordSendFragment();
    }
}
