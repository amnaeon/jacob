package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.stus.jacob.R;

/**
 * Created by stus on 14.05.17.
 */

public class TestsFragment extends BaseFragment {

    public Button fourVariantsTestBtn, relationTestBtn, writingTestBtn, pairTestBtn, fullTestBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(viewID(), container, false);
        fourVariantsTestBtn = (Button) root.findViewById(R.id.fourVariantsTestBtn);
        relationTestBtn = (Button) root.findViewById(R.id.relationTestBtn);
        writingTestBtn = (Button) root.findViewById(R.id.writingTestBtn);
        pairTestBtn = (Button) root.findViewById(R.id.pairTestBtn);
        fullTestBtn = (Button) root.findViewById(R.id.fullTestBtn);

        fourVariantsTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return root;
    }

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
