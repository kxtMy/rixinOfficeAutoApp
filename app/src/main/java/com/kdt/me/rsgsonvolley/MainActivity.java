package com.kdt.me.rsgsonvolley;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kdt.me.rsgsonvolley.ListOA.Results;
import com.kdt.me.rsgsonvolley.ListOA.RsVolley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final static String URL="http://gank.io/api/data/Android/10/1";
    RsVolley rsVolley;
    ListView listView;
    List<Results> resultsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler=new Handler();
        rsVolley=new RsVolley(MainActivity.this);
        List<String> list=new ArrayList<String>();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        rsVolley.getBoard(URL,list,arrayAdapter);
        listView=(ListView)findViewById(R.id.boardlist);
        //handler.handleMessage();
        /*for(int i=0;i<resultsList.size();i++) {
            Log.v("msg","描述"+resultsList.get(i).getDesc());
            list.add(resultsList.get(i).getDesc());
        }*/

        listView.setAdapter(arrayAdapter);

    }

}
