package com.example.administrator.zy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.administrator.zy.Data.API;
import com.example.administrator.zy.R;
import com.example.administrator.zy.Util.httputil;

/**
 * Created by Administrator on 2018/5/26.
 */

public class LoginActivity extends AppCompatActivity {


    private EditText editText1;
    private EditText editText2;
    Button button;
    static String acount;
    static String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        editText1 = (EditText)findViewById(R.id.accout);
        editText2 = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.denglu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acount = editText1.getText().toString();
                password = editText2.getText().toString();
                httputil.sendHttpRequest(API.denglu, "stuNum=" + acount + "&idNum=" + password, new httputil.Callback() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject object = null;
                        try {
                            object = new JSONObject(response);
                            String status = object.getString("status");
                            if(status.equals("200")){
                                Intent intent = new Intent(LoginActivity.this,Kebiao1Activity.class);
                                intent.putExtra("acount",acount);
                                intent.putExtra("password",password);
                                startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }
    public static String getAcount(){
        return acount;
    }
    public static String getPassword(){
        return password;
    }

}

