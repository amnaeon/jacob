package com.example.stus.jacob.fragments;

import com.example.stus.jacob.R;
import com.example.stus.jacob.models.SendRecomendationModel;

import java.util.List;

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

    @Override
    protected Initer getInit() {
        return super.getInit().add(this::initList);
    }

    private void initList() {
        //// TODO: 14.05.17 make getRecomendet api and init list

    }
    
    private void save(List<SendRecomendationModel> sendRecomendationModelList){
        //// TODO: 14.05.17 make setRecomendation query
    }
}
