package com.example.vanluc.buoi8;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class InfoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Info> listInfo;
    public static String keyName = "Abc";

    public InfoAdapter(Context context, ArrayList<Info> listInfo, int layoutResource) {
        this.context = context;
        this.listInfo = listInfo;
    }

    @Override
    public int getCount() {
        return listInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return listInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        TextView tv_Tittle, tv_IdUser;
    }

    public InfoAdapter(Context context, ArrayList<Info> listInfo) {
        this.context = context;
        this.listInfo = listInfo;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_listview_test, null);
        TextView tv_IdUser = view.findViewById(R.id.tv_IdUser);
        TextView tv_Tittle = view.findViewById(R.id.tv_Tittle);
        final LinearLayout ln_Test = view.findViewById(R.id.ln_Test);
        tv_IdUser.setText(String.valueOf(listInfo.get(i).getUserID()));
        tv_Tittle.setText(listInfo.get(i).getTittle());
        ln_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BodyActivity.class);
                intent.putExtra(keyName, listInfo.get(i).getBody());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
