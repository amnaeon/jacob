package com.example.stus.jacob.fragment_dialog;

import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stus.jacob.Const;
import com.example.stus.jacob.R;
import com.example.stus.jacob.interfaces.restApiInterfaces.IAddText;
import com.example.stus.jacob.managers.UiManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by stus on 13.05.17.
 */

public class ModeFragmentDialog extends DialogFragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle arg = getArguments();
        View parent;
        if (arg.getInt("type") == Const.ARTICLE_TYPE) {
            parent = inflater.inflate(R.layout.article_dialog, container, false);
            parent.findViewById(R.id.search).setOnClickListener(v -> {
                TextView search;
                search = (TextView) parent.findViewById(R.id.articleUrl);
                if (search.getText().length()!=0
                        & URLUtil.isValidUrl(search.getText().toString())) {
                    makeQuery(search.getText().toString());
                    UiManager.showWordSendFragment();
                    dismiss();
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Невалидный URL", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        } else {
            parent = inflater.inflate(R.layout.subtitles_dialog, container, false);
            parent.findViewById(R.id.search).setOnClickListener(v -> {
                TextView search;
                search = (TextView) parent.findViewById(R.id.articleUrl);
                if (search.getText().length() != 0) {
                    UiManager.showSubtitlesFragment(search.getText().toString());
                    dismiss();
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Введите название фильма", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }

        return parent;
    }

    private String makeQuery(String search) {
        //// TODO: 14.05.17 make adding query
        String res="";
        SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);
        IAddText gitHubService = IAddText.retrofit.create(IAddText.class);
        Call<String> call = gitHubService.addText(search,sharedPreferences.getString(Const.USER_CONST.USER_ID,""),
                sharedPreferences.getString(Const.USER_CONST.CHAT_ID,""),sharedPreferences.getString(Const.USER_CONST.USER_NAME,""));
        try {
            res = call.execute().body();
        } catch (IOException e) {
            return "";
        }
        return res;
    }
}
