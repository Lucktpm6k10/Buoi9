package com.example.vanluc.buoi8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BodyActivity extends AppCompatActivity {
    TextView tv_Detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        initView();
        Intent intent = getIntent();
        String detail = intent.getStringExtra(InfoAdapter.keyName);
        tv_Detail.setText(detail);
    }

    private void initView() {
        tv_Detail = findViewById(R.id.tv_Detail);
    }
}
