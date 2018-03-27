package com.example.butterknife.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.butterknife.R;
import com.example.butterknife.ui.DemoFragment;
import com.example.butterknife.utils.Utils;


public class DummyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        displayLoginFargment();
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

    private void displayLoginFargment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment frag = Utils.getFragment(fm, DemoFragment.class);
        if (!frag.isAdded()) {
            ft.add(R.id.content_view, frag, DemoFragment.class.getSimpleName());
        } else {
            ft.replace(R.id.content_view, Utils.getFragment(fm, DemoFragment.class), DemoFragment.class.getSimpleName());
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
