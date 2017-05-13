package com.example.stus.jacob.managers;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.example.stus.jacob.MainActivity;
import com.example.stus.jacob.R;
import com.example.stus.jacob.fragments.BaseFragment;
import com.example.stus.jacob.fragments.MainFragment;
import com.example.stus.jacob.fragments.SubtitlesSendFragment;
import com.example.stus.jacob.fragments.SubtitliesFragment;
import com.example.stus.jacob.fragments.WordSelectorFragment;

import java.util.Stack;


/**
 * Created on 12.02.16.
 */
public class UiManager implements NavigationView.OnNavigationItemSelectedListener {
    private static UiManager ourInstance = new UiManager();
    private MainActivity parent;

    private Stack<BaseFragment> backStack = new Stack<>();

    public static UiManager getInstance() {
        return ourInstance;
    }

    private UiManager() {
    }


    public void init(MainActivity parent) {
        this.parent = parent;
        parent.setContentView(R.layout.activity_main);
//
//        NavigationView navigationView = (NavigationView) parent.findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) parent.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public boolean back() {
        DrawerLayout drawer = (DrawerLayout) parent.findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }
        if (backStack.size() < 2) return true;
        if (backStack.lastElement().onBackPressed()) {
            backStack.pop();
            showFragment(backStack.pop());
            return false;
        }
        return true;
    }

    protected void showFragment(BaseFragment fragment) {
        FragmentManager manager = parent.getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        backStack.push(fragment);

        ft = manager.beginTransaction();
        ft.replace(R.id.main_container, fragment);
        if (!commitTransaction(ft)) return;
        if (manager == null) return;
        manager.executePendingTransactions();
        DrawerLayout drawer = (DrawerLayout) parent.findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    private boolean commitTransaction(FragmentTransaction ft) {
        try {
            ft.commit();
        } catch (Exception e) {
            //todo log it
            try {
                ft.commitAllowingStateLoss();
            } catch (Exception e1) {
                //todo Log it
                return false;
            }
        }
        return true;
    }




    public void hideNavigationDriver() {
        DrawerLayout drawer = (DrawerLayout) parent.findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void showNavigationDriver() {
        DrawerLayout drawer = (DrawerLayout) parent.findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (backStack == null || backStack.empty())
            return;
        backStack.peek().onActivityResult(requestCode, resultCode, data);
    }

    public static void showMainFragment(){
        getInstance().showFragment(MainFragment.getInstance());
    }

    public static void showWordSelectorFragment(){
        getInstance().showFragment(WordSelectorFragment.getInstance());
    }

    public static void showSubtitlesFragment(){
        getInstance().showFragment(SubtitliesFragment.getInstance());
    }

    public static void showSubtitlesSendFragment(){
        getInstance().showFragment(SubtitlesSendFragment.getInstance());
    }
}
