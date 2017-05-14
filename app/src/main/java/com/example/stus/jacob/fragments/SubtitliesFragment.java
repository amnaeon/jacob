package com.example.stus.jacob.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.stus.jacob.R;
import com.example.stus.jacob.adapters.SubtitlesAdapter;
import com.example.stus.jacob.interfaces.IOnTouch;
import com.example.stus.jacob.interfaces.restApiInterfaces.IGetRecomendation;
import com.example.stus.jacob.managers.UiManager;
import com.example.stus.jacob.models.RecomendtionModel;
import com.example.stus.jacob.subtitlesLogic.FilmItem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by stus on 13.05.17.
 */

public class SubtitliesFragment extends BaseFragment implements IOnTouch {
    @Override
    protected int viewID() {
        return R.layout.subtitles_fragment;
    }

    public static SubtitliesFragment getInstance() {
        return new SubtitliesFragment();
    }

    @Override
    protected Initer getInit() {
        return super.getInit().add(this::initList);
    }

    private void initList() {
        String url = "https://pp.userapi.com/c622030/v622030045/4bf14/uR_ojSWXOAs.jpg";
        RecyclerView list = (RecyclerView) parent.findViewById(R.id.subtitles_list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        SubtitlesAdapter adapter = new SubtitlesAdapter(getContext());
        adapter.setData(Arrays.asList(new FilmItem("dfdfdf", url, "sdsdsd")
                , new FilmItem("eeeeee", url, "rrrrrrr"), new FilmItem("dddede", url, "eeeeeeeee")));
        adapter.setiOnTouch(this);
        list.setAdapter(adapter);

    }

    @Override
    public void onTouch(FilmItem filmItem) {
        //// TODO: 14.05.17 adding request
        IGetRecomendation recomendation = IGetRecomendation.retrofit.create(IGetRecomendation.class);
        Call<List<RecomendtionModel>> call = recomendation.getRecomendation(158074167);
        call.enqueue(new Callback<List<RecomendtionModel>>() {
            @Override
            public void onResponse(Call<List<RecomendtionModel>> call, Response<List<RecomendtionModel>> response) {
                UiManager.showSubtitlesSendFragment();

            }

            @Override
            public void onFailure(Call<List<RecomendtionModel>> call, Throwable t) {

            }

        });
    }
}

