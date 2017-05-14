package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.stus.jacob.R;
import com.example.stus.jacob.adapters.WordSelectorAdapter;
import com.example.stus.jacob.models.RecomendtionModel;
import com.example.stus.jacob.models.SendRecomendationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stus on 13.05.17.
 */

public class WordSelectorFragment extends BaseFragment{

    private RecyclerView wordSelectorList;
    private Button saveButton;
    private LinearLayout layouContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(viewID(), container, false);
        saveButton = (Button) root.findViewById(R.id.saveButton);
        wordSelectorList = (RecyclerView) root.findViewById(R.id.wordSelectorList);
        wordSelectorList.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<RecomendtionModel> list = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            list.add(new RecomendtionModel(i, "word"+i));
        }
        WordSelectorAdapter adapter = new WordSelectorAdapter(list);
        adapter.setSaveButton(saveButton);
        wordSelectorList.setAdapter(adapter);

        layouContainer = (LinearLayout) root.findViewById(R.id.layoutContainer);
        return root;
    }

    @Override
    protected int viewID() {
        return R.layout.word_selector_fragment;
    }

    public static WordSelectorFragment getInstance(){
        return new WordSelectorFragment();
    }

    private void initList() {
        //// TODO: 14.05.17 make getRecomendet api and init list

    }

    private void save(List<SendRecomendationModel> sendRecomendationModelList){
        //// TODO: 14.05.17 make setRecomendation query
    }
}
