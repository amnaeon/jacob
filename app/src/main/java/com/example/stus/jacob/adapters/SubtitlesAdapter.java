package com.example.stus.jacob.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.stus.jacob.holders.SubtitlesHolder;
import com.example.stus.jacob.subtitlesLogic.FilmItem;

import java.util.List;

/**
 * Created by stus on 13.05.17.
 */

public class SubtitlesAdapter extends RecyclerView.Adapter<SubtitlesHolder> {
    private Context context;
    private List<FilmItem> filmItemList;

    public SubtitlesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SubtitlesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SubtitlesHolder.getInstance(context);
    }

    @Override
    public void onBindViewHolder(SubtitlesHolder holder, int position) {
        holder.update(filmItemList.get(position),context);
    }

    @Override
    public int getItemCount() {
        return filmItemList.size();
    }

    public void setData(List<FilmItem> filmItemList){
        this.filmItemList = filmItemList;
    }
}
