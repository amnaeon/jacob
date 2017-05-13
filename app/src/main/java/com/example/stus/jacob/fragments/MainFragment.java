package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.widget.Button;

import com.example.stus.jacob.Const;
import com.example.stus.jacob.R;
import com.example.stus.jacob.fragment_dialog.ModeFragmentDialog;

/**
 * Created by stus on 13.05.17.
 */

public class MainFragment extends BaseFragment {
    @Override
    protected int viewID() {
        return R.layout.main_fragment;
    }

    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Override
    protected Initer getInit() {
        return super.getInit().add(this::init);
    }

    private void init() {
        parent.findViewById(R.id.subtitlels).setOnClickListener(v -> {
            Bundle arg = new Bundle();
            arg.putInt("type", Const.SUBTITLES_TYPE);
            ModeFragmentDialog fragmentDialog = new ModeFragmentDialog();
            fragmentDialog.setArguments(arg);
            fragmentDialog.show(getActivity().getFragmentManager(),"dialog");
        });

        parent.findViewById(R.id.articles).setOnClickListener(v -> {
            Bundle arg = new Bundle();
            arg.putInt("type", Const.ARTICLE_TYPE);
            ModeFragmentDialog fragmentDialog = new ModeFragmentDialog();
            fragmentDialog.setArguments(arg);
            fragmentDialog.show(getActivity().getFragmentManager(),"dialog");
        });
    }
}
