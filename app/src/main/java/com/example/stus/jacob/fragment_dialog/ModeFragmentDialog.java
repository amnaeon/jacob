package com.example.stus.jacob.fragment_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stus.jacob.Const;
import com.example.stus.jacob.R;
import com.example.stus.jacob.managers.UiManager;

import com.example.stus.jacob.models.requestModel.AddTextRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by stus on 13.05.17.
 */

public class ModeFragmentDialog extends DialogFragment {

    public static String LOG = "ModeFragmentDialog";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle arg = getArguments();
        View parent;
        if (arg.getInt("type") == Const.ARTICLE_TYPE) {
            parent = inflater.inflate(R.layout.article_dialog, container, false);
            parent.findViewById(R.id.search).setOnClickListener(v -> {
                TextView search;
                search = (TextView) parent.findViewById(R.id.articleUrl);
                if (search.getText().length() != 0
                        & URLUtil.isValidUrl(search.getText().toString())) {
                    makeQuery(search.getText().toString());
                if (((TextView) parent.findViewById(R.id.articleUrl)).getText().length()!=0
                        & URLUtil.isValidUrl(((TextView) parent.findViewById(R.id.articleUrl)).getText().toString())) {
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
                search = (TextView) parent.findViewById(R.id.filmName);
                if (((TextView) parent.findViewById(R.id.filmName)).getText().length() != 0
                        &((((TextView) parent.findViewById(R.id.filmName)).getText()).toString().trim()).length()!=0) {
                    UiManager.showSubtitlesFragment(search.getText().toString().trim());
                    dismiss();
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Введите название фильма", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }

        return parent;
    }

    private void makeQuery(String search) {

        //// TODO: 14.05.17 make adding query

        SharedPreferences sharedPreferences = getActivity().getPreferences(MODE_PRIVATE);
        IAddText gitHubService = IAddText.retrofit.create(IAddText.class);

        AddTextRequest body = new AddTextRequest();
        body.userID = sharedPreferences.getString(Const.USER_CONST.USER_ID, "12432dds");
        body.chatID = sharedPreferences.getString(Const.USER_CONST.CHAT_ID, "dfkjf)");
        body.userName = sharedPreferences.getString(Const.USER_CONST.USER_NAME, "androidApp");
        body.text = search;
        Call<Object> call = gitHubService.addText(body);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.i(LOG, "success added new word");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e(LOG, "can not add new word", t);
            }
        });
    }
}
