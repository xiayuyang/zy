package com.example.administrator.zy.Util;

import com.example.administrator.zy.Data.API;
import com.example.administrator.zy.Util.httputil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018/5/26.
 */

public class information {
    private static String name = "";
    private static String nicker;
    private static String gender;
    private static String image;
    public static void getinform(String acount, String password){
        httputil.sendHttpRequest(API.information, "stuNum=" + acount + "idNum" + password, new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                JSONObject object = new JSONObject(response);
                JSONObject jsonObject = object.getJSONObject("data");
                 name = jsonObject.getString("usename");
                 nicker = jsonObject.getString("nickname");
                 gender = jsonObject.getString("gender");
                image = jsonObject.getString("photo_thumbnail_src");
            }
        });
    }
    public String getname(){
        return name ;
    }
    public static String getNicker(){
        return nicker;
    }
    public String getGender(){
        return gender;
    }
    public String getImage(){
        return image;
    }
}
