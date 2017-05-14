package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.stus.jacob.Const;
import com.example.stus.jacob.R;
import com.example.stus.jacob.adapters.SubtitlesAdapter;
import com.example.stus.jacob.interfaces.IOnTouch;
import com.example.stus.jacob.managers.UiManager;
import com.example.stus.jacob.subtitlesLogic.FilmItem;

import java.util.Arrays;

/**
 * Created by stus on 13.05.17.
 */

public class SubtitliesFragment extends BaseFragment implements IOnTouch {
    private String url;

    @Override
    protected int viewID() {
        return R.layout.subtitles_fragment;
    }

    public static SubtitliesFragment getInstance(String url) {
        Bundle arg = new Bundle();
        arg.putString(Const.BundleConst.SUBTITLE_URL,url);
        SubtitliesFragment result = new SubtitliesFragment();
        result.setArguments(arg);
        return result;
    }

    @Override
    protected Initer getInit() {
        return super.getInit().add(this::readArg).add(this::initList);
    }

    private void readArg() {
        Bundle arg = getArguments();
        if(arg!=null)
            url = arg.getString(Const.BundleConst.SUBTITLE_URL);
    }

    private void initList() {
        //// TODO: 14.05.17 make subtite api
        String url = "https://pp.userapi.com/c622030/v622030045/4bf14/uR_ojSWXOAs.jpg";
        RecyclerView list = (RecyclerView) parent.findViewById(R.id.subtitles_list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        SubtitlesAdapter adapter = new SubtitlesAdapter(getContext());
        adapter.setData(Arrays.asList(new FilmItem("Scream of soul and something else", url, "sdsdsd")
                , new FilmItem("eeeeee", url, "rrrrrrr"), new FilmItem("dddede", url, "eeeeeeeee")));
        adapter.setiOnTouch(this);
        list.setAdapter(adapter);

    }

    @Override
    public void onTouch(FilmItem filmItem) {
        //// TODO: 14.05.17 adding request
       UiManager.showWordSendFragment();
    }
}

