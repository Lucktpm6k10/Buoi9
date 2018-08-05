package com.example.vanluc.buoi8;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv_Test;
    InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        myAsynTask asynTask = new myAsynTask();
        asynTask.execute();
        initListener();
    }

    private void initListener() {
        lv_Test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    private void initView() {
        lv_Test = findViewById(R.id.lv_Test);

    }

    public class myAsynTask extends AsyncTask<String, Void, ArrayList<Info>> {
        @Override
        protected void onPostExecute(ArrayList<Info> infos) {
            super.onPostExecute(infos);
            Toast.makeText(MainActivity.this, "" + getResources().getString(R.string.loadXong), Toast.LENGTH_SHORT).show();
            infoAdapter = new InfoAdapter(getApplicationContext(), infos);
            lv_Test.setAdapter(infoAdapter);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "" + getResources().getString(R.string.dangLoad), Toast.LENGTH_SHORT).show();
        }

        @Override
        protected ArrayList<Info> doInBackground(String... strings) {
            ArrayList<Info> result = new ArrayList<Info>();
            try {
                URL u = new URL("https://jsonplaceholder.typicode.com/posts");
                HttpURLConnection conn = (HttpURLConnection) u.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder builder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
                JSONArray jsonArray = new JSONArray(builder.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Info itemInfo = new Info();
                    if (jsonObject.has("userId"))
                        itemInfo.setUserID(jsonObject.getInt("userId"));
                    if (jsonObject.has("id"))
                        itemInfo.setUserID(jsonObject.getInt("id"));

                    if (jsonObject.has("userId"))
                        itemInfo.setTittle(jsonObject.getString("title"));
                    if (jsonObject.has("userId"))
                        itemInfo.setBody(jsonObject.getString("body"));
                    result.add(itemInfo);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}