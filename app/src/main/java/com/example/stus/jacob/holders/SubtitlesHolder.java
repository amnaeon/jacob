package com.example.stus.jacob.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stus.jacob.R;
import com.example.stus.jacob.interfaces.IOnTouch;
import com.example.stus.jacob.subtitlesLogic.FilmItem;
import com.squareup.picasso.Picasso;

/**
 * Created by stus on 13.05.17.
 */

public class SubtitlesHolder extends RecyclerView.ViewHolder {
    private ImageView photo;
    private TextView name;
    private Context context;
    private IOnTouch iOnTouch;

    public SubtitlesHolder(View itemView) {
        super(itemView);
        photo = (ImageView)itemView.findViewById(R.id.film_image);
        name = (TextView)itemView.findViewById(R.id.title);
    }

    public static SubtitlesHolder getInstance(Context context){
        SubtitlesHolder result = new SubtitlesHolder(LayoutInflater.from(context).inflate(R.layout.subtitles_holder, null));
        return result;
    }

    public void update(FilmItem filmItem,Context context) {
        Picasso.with(context).load(filmItem.getPosterAddress()).resize(150,150).centerCrop().into(photo);
        name.setText(filmItem.getTitle());
        iOnTouch.onTouch(filmItem);
    }
}
