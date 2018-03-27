package com.example.butterknife.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.butterknife.R;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DemoFragment extends Fragment {
    Unbinder unbinder;

    //binding view id;
    @BindView(R.id.text_title)
    TextView mTitle;

    @BindView(R.id.img_view)
    ImageView imgLogo;

    //binding string id;
    @BindString(R.string.title)
    String title;

    //binding drawable id;
    @BindDrawable(R.mipmap.ic_launcher)
    Drawable mDrawable;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.fragment_demo, container, false);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, mContentView);
        setTextView();
        setImageView();
        return mContentView;

    }

    private void setTextView() {
        mTitle.setText(title);
    }

    private void setImageView() {
        imgLogo.setImageDrawable(mDrawable);
    }

    @OnClick(R.id.btn)
    public void backPress() {
        getActivity().onBackPressed();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // unbind the view to free some memory
        unbinder.unbind();
    }
}