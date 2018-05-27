package com.example.administrator.zy.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.zy.Data.API;
import com.example.administrator.zy.Interface.OnRecyclerviewItemClickListener;
import com.example.administrator.zy.Data.QustionData;
import com.example.administrator.zy.R;
import com.example.administrator.zy.Adapter.RvAdapter;
import com.example.administrator.zy.Util.datautil;
import com.example.administrator.zy.Util.httputil;
import com.example.administrator.zy.Util.information;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class YouWenActivity extends AppCompatActivity implements Runnable {
    private static final int REFRESHED = 0x126;
    private static final int MORE_NEWS = 0x127;
    private static final int START_NEWS = 0x128;
    private int id;
    private SwipeRefreshLayout mRefreshLayout;
    private LinearLayoutManager mLayoutManager;
    private RvAdapter mRvAdapter;
    private RecyclerView mRecyclerView;
    private boolean loading = false;
    private GregorianCalendar calendar;
    private Context context;
    ImageButton imageButton;
    List<Integer> ids = new ArrayList<>();
QustionData[] list;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message){
            super.handleMessage(message);
            switch (message.what){
                case START_NEWS:
                    mRecyclerView.setAdapter(mRvAdapter);
                    break;
                case REFRESHED:
                    mRefreshLayout.setRefreshing(false);
                    mRvAdapter.notifyDataSetChanged();
                    break;
                case MORE_NEWS:
                    mRvAdapter.notifyDataSetChanged();
                    break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youwen);
        calendar = new GregorianCalendar();
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpRecyclerView();
        setUpSwipeRefreshLayout();
        imageButton = (ImageButton)findViewById(R.id.more);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(YouWenActivity.this,TiwenActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void setUpSwipeRefreshLayout() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_rl);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread( YouWenActivity.this).start();
            }
        });


    }
    private void setUpRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(YouWenActivity.this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        httputil.sendHttpRequest(API.qustion, "page=1&count=6&kind=其他", new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                list = getQuestion(response);
                mRvAdapter = new RvAdapter(list,ids,YouWenActivity.this,onRecyclerviewItemClickListener);
                handler.sendEmptyMessage(START_NEWS);
            }
        });


    }

    public QustionData[] getQuestion(String response) throws JSONException {


        JSONObject object = null;
        JSONArray jsonArray = null;
        object = new JSONObject(response);
List<QustionData> mlist = new ArrayList<>();
        jsonArray = object.getJSONArray("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            String title = jsonArray.getJSONObject(i).getString("title");
            String description = jsonArray.getJSONObject(i).getString("description");
            String create_at = jsonArray.getJSONObject(i).getString("created_at");
            int id = jsonArray.getJSONObject(i).getInt("id");
            String nicker = jsonArray.getJSONObject(i).getString("nickname");
            String gender = jsonArray.getJSONObject(i).getString("gender");
            String image = jsonArray.getJSONObject(i).getString("photo_thumbnail_src");
            ids.add(id);
            mlist.add(new QustionData(title, description, gender,create_at, id, image, nicker));
        }


        return mlist.toArray(new QustionData[]{});
    }


    @Override
    public void run() {
        httputil.sendHttpRequest(API.qustion, "page=1&count=7&kind=其他", new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                list = getQuestion(response);
                mRvAdapter = new RvAdapter(list,ids,YouWenActivity.this,onRecyclerviewItemClickListener);
                handler.sendEmptyMessage(REFRESHED);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data ){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    final String title1 = data.getStringExtra("title");
                    final String description1= data.getStringExtra("description");
                    //final String image1 = data.getStringExtra("image");
                    information.getinform(LoginActivity.getAcount(),LoginActivity.getPassword());
                    final String nicker1 = information.getNicker();
                    final String gender = "男";
                    httputil.sendHttpRequest(API.tiwen, "stuNum=" + LoginActivity.getAcount() + "&idNum=" + LoginActivity.getPassword() + "&title=" + title1 + "&description=" + description1 + "&is_anonymous=0&kind=其他&tags=PHP&reward=2&disappear_time=2018-05-27 01:11:20", new httputil.Callback() {
                        @Override
                        public void onResponse(String response) throws JSONException {
                            JSONObject object = new JSONObject(response);
                            JSONObject jsonObject = object.getJSONObject("data");
                            id = jsonObject.getInt("id");
                            List<QustionData> list1 = new ArrayList<>();
                            list1.add(new QustionData(title1,description1,gender, datautil.formatDateTime(datautil.getCurrentDate()),id,null,nicker1));
                            list1.addAll(Arrays.asList(list));
                            list = list1.toArray(new QustionData[]{});
                            handler.sendEmptyMessage(MORE_NEWS);
                        }
                    });
                }
        }
    }


    private OnRecyclerviewItemClickListener onRecyclerviewItemClickListener = new OnRecyclerviewItemClickListener() {
        @Override
        public void onItemClickListener(View v, int position) {
            Intent intent = new Intent(YouWenActivity.this,WentiActivity.class);
            intent.putExtra("id",position);
           startActivity(intent);
        }
    };
}

