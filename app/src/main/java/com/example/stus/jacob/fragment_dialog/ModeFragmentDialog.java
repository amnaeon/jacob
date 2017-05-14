package com.example.stus.jacob.fragment_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
                if (((TextView) parent.findViewById(R.id.articleUrl)).getText().length()!=0
                        & URLUtil.isValidUrl(((TextView) parent.findViewById(R.id.articleUrl)).getText().toString())) {
                    UiManager.showWordSelectorFragment();
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
}
