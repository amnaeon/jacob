package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.stus.jacob.R;

/**
 * Created by root on 14.05.17.
 */

public class FourVariantsTestFragment extends BaseFragment {
    public TextView answerWord;
    public Button oneBtn, twoBtn, threeBtn, fourBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(viewID(), container, false);
        answerWord = (TextView) root.findViewById(R.id.answerWord);
        oneBtn = (Button) root.findViewById(R.id.oneBtn);
        twoBtn = (Button) root.findViewById(R.id.twoBtn);
        threeBtn = (Button) root.findViewById(R.id.threeBtn);
        fourBtn = (Button) root.findViewById(R.id.fourBtn);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int viewID() {
        return R.layout.four_variants_test_fragment;
    }

    public static FourVariantsTestFragment getInstance() {
        return new FourVariantsTestFragment();
    }
}
