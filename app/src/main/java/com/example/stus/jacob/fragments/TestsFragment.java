package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.stus.jacob.R;
import com.example.stus.jacob.managers.UiManager;
import com.example.stus.jacob.models.WordModel;

import java.util.ArrayList;

/**
 * Created by stus on 14.05.17.
 */

public class TestsFragment extends BaseFragment {

    public Button fourVariantsTestBtn, relationTestBtn, writingTestBtn, pairTestBtn, fullTestBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(viewID(), container, false);

        ArrayList<WordModel> words = initWords();

        fourVariantsTestBtn = (Button) root.findViewById(R.id.fourVariantsTestBtn);
        relationTestBtn = (Button) root.findViewById(R.id.relationTestBtn);
        writingTestBtn = (Button) root.findViewById(R.id.writingTestBtn);
        pairTestBtn = (Button) root.findViewById(R.id.pairTestBtn);
        fullTestBtn = (Button) root.findViewById(R.id.fullTestBtn);

        fourVariantsTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiManager.showFourVariantsTestFragment(words);
            }
        });
        return root;
    }

    private ArrayList<WordModel> initWords() {
        ArrayList<WordModel> words = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            words.add(new WordModel(""+i, "word"+i, "перевод"+i));
        }
        return null;
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
