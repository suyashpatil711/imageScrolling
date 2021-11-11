package com.example.scrollingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private static String json_url ="https://pastebin.com/raw/wgkJgazE";

        List<ScrollMainClass> scroll_list;
        RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll_list =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);

        GetData getData =new GetData();
        getData.execute();
    }
    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {

            String current =" ";

            try{
                    URL url;
                HttpURLConnection urlConnection=null;
                try{
                    url=new URL(json_url);
                    urlConnection=(HttpURLConnection) url.openConnection();

                    InputStream is=urlConnection.getInputStream();
                    InputStreamReader isr= new InputStreamReader(is);

                    int data=isr.read();
                    while(data != -1){
                        current += (char) data;
                        data=isr.read();
                    }
                        return current;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if(urlConnection !=null)
                        urlConnection.disconnect();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {


            try{

                JSONArray jsonArray=new JSONArray(s);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);
                    ScrollMainClass scrollmain=new ScrollMainClass();
                    scrollmain.setId(jsonObject1.getString("id"));
                    scrollmain.setLikes(jsonObject1.getString("likes"));

                    JSONObject ouser=jsonObject1.getJSONObject("user");
                    scrollmain.setUser(ouser.getString("id"),ouser.getString("name"));

                    JSONObject oprofimg=ouser.getJSONObject("profile_image");
                    scrollmain.getUser().setProfImgClass(oprofimg.getString("small"),
                            oprofimg.getString("medium"),oprofimg.getString("large"));


                    scroll_list.add(scrollmain);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            PutDataIntoRecyclerView(List<ScrollMainClass> scroll_list);
        }
    }
            private void PutDataIntoRecyclerView(List<ScrollMainClass> scroll_list){

            Adapter adapter=new Adapter(this,scroll_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(adapter);
            }

}