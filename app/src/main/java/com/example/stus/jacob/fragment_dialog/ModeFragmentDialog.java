package com.example.stus.jacob.fragment_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
                UiManager.showWordSelectorFragment();
                dismiss();
            });
        } else {
            parent = inflater.inflate(R.layout.subtitles_dialog, container, false);
            parent.findViewById(R.id.search).setOnClickListener(v -> {
                UiManager.showSubtitlesFragment();
                dismiss();
            });
        }

        return parent;
    }
}
