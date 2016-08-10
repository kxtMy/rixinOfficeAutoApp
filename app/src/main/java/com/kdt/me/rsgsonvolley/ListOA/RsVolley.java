package com.kdt.me.rsgsonvolley.ListOA;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by ME on 2016/8/7.
 */
public class RsVolley{
    Context context;
    RequestQueue requestQueue;
    public RsVolley(Context context){
        this.context=context;
        //建立请求队列
       requestQueue= Volley.newRequestQueue(this.context);
    }
    //1聊天
    //发送聊天数据（私聊，群组（String发起人,String 聊天信息，Boolean 群聊OR私聊，String 目标帐号,String 目标群））
    //获取聊天数据（Boolean群名/目标帐号，int获取消息的条数,String 发起人，String 目标帐号）
    //2
    //获取公告(String部门，String标题,data时间,String 发布者，String内容，)
    //3
    //添加好友（获取帐号信息（个人信息））获取查询出帐号对应的好友
    //4
    //获取个人信息（帐号，电话号，性别，部门，职位，年级，专业，备注，头像）
    //获取好友列表
    public void getBoard(String URL, final List<String> list, final ArrayAdapter arrayAdapter){

        final JsonObjectRequest mjsonObject=new JsonObjectRequest(URL,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson=new Gson();
                //Type type=new TypeToken<ResultsBean>(){}.getType();

                ResultsBean mresultsBean=gson.fromJson(jsonObject.toString(),ResultsBean.class);
                List<Results> mresultsList=mresultsBean.getResultsList();
                for(int i=0;i<mresultsList.size();i++) {
                    Log.v("msg", "描述" + mresultsList.get(i).getDesc());
                    list.add(mresultsList.get(i).getDesc());
                }
                arrayAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(mjsonObject);
        //Log.v("msg",boardList.size()+"");
        requestQueue.start();
    }

}
