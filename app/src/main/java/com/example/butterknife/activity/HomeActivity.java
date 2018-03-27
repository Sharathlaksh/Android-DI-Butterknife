package com.example.butterknife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.butterknife.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.title)
    TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Butterknife
        ButterKnife.bind(this);
        setTextView();
    }

    private void setTextView() {
        mTitle.setText(R.string.title);
    }

    @OnClick(R.id.btn_click)
    public void startActivity() {
        Intent mIntent = new Intent(this, DummyActivity.class);
        startActivity(mIntent);
    }


}
