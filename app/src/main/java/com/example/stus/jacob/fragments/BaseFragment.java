package com.example.stus.jacob.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.stus.jacob.IUiItemStatus;
import com.example.stus.jacob.MainActivity;
import com.example.stus.jacob.R;
import com.example.stus.jacob.managers.UiManager;


import java.util.ArrayList;
import java.util.List;


public abstract class BaseFragment extends Fragment implements IUiItemStatus {
    protected boolean isAvalible;
    protected View parent;
    private Toolbar toolbar;

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    @Override
    public void onResume() {
        this.isAvalible = true;
        super.onResume();
    }

    @Override
    public void onPause() {
        isAvalible = false;
        super.onPause();
    }

    @Override
    public boolean isGetResponse() {
        return isAvalible;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.parent = inflater.inflate(viewID(), null, false);
        setHasOptionsMenu(true);
        updateNavigationDriver();
        getInit().exec();
        return parent;
    }

    protected void updateNavigationDriver() {
        if (enableDriwer()) {
            UiManager.getInstance().showNavigationDriver();
        } else
            UiManager.getInstance().hideNavigationDriver();
    }


    protected String getTitle() {
        return getMainActivity().getString(R.string.app_name);
    }

    protected boolean enableDriwer() {
        return true;
    }


    protected abstract int viewID();

    protected Initer getInit() {
        return new Initer();
    }

    public boolean onBackPressed() {
        return true;
    }

    protected final class Initer {
        List<Runnable> initList;

        public Initer() {
            initList = new ArrayList<>();
        }

        public Initer add(Runnable runnable) {
            initList.add(runnable);
            return this;
        }

        private void exec() {
            for (Runnable r : initList) r.run();
        }

    }
}