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
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.zy.Data.API;
import com.example.administrator.zy.Data.AnswerData;
import com.example.administrator.zy.Adapter.Answeradapter;
import com.example.administrator.zy.ImageLoder.DoubleCache;
import com.example.administrator.zy.ImageLoder.ImageLoader;
import com.example.administrator.zy.Data.QustionData;
import com.example.administrator.zy.R;
import com.example.administrator.zy.Util.httputil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WentiActivity extends AppCompatActivity implements Runnable{
    private final String TAG = "Wenti";
    ImageView imageView;
    TextView nicker;
    ImageView gender;
    TextView title;
    TextView description;
    TextView creat;
    Context context;
    ImageView imageView1;
    ImageView imageView2;
    Answeradapter answeradapter;
   int id;
    AnswerData[] answerData;
    List<String> stringList = new ArrayList<>();
RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private LinearLayoutManager mLayoutManager;
List<Integer> integerList = new ArrayList<>();

private ImageLoader imageLoader;
    private static final int REFRESHED1 = 0x111;
    private static final int MORE_NEWS1 = 0x112;
    private static final int START_NEWS1 = 0x113;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wenti);
        imageView = (ImageView) findViewById(R.id.avatar1);
        nicker = (TextView) findViewById(R.id.nicker1);
        gender = (ImageView) findViewById(R.id.gender1);
        title = (TextView) findViewById(R.id.title2);
        description = (TextView) findViewById(R.id.description1);
        creat = (TextView) findViewById(R.id.jifen1);
        imageLoader = new ImageLoader();
        Intent intent = getIntent();
         //id = intent.getIntExtra("id", 59);
        id = 19;
        DoubleCache doubleCache = new DoubleCache(WentiActivity.this);
        imageLoader.setImageCache(doubleCache);
        get();
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        setUpRecyclerView();
        setUpSwipeRefreshLayout();
    }
    private void setUpSwipeRefreshLayout() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.wenti);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread( WentiActivity.this).start();
            }
        });


    }
    @Override
    public void run() {
        httputil.sendHttpRequest(API.wenti, "stuNum=" + LoginActivity.getAcount() + "idNum=" + LoginActivity.getPassword() + "question_id=" + id, new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                JSONObject jsonObjectq = new JSONObject(response);
                JSONArray jsonArrayq = jsonObjectq.getJSONArray("answers");
                answerData = getAnswer(jsonArrayq);
                answeradapter = new Answeradapter(answerData, integerList, WentiActivity.this);
                handler.sendEmptyMessage(REFRESHED1);

            }
        });
    }
    private void setUpRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.rv1);
        mLayoutManager = new LinearLayoutManager(WentiActivity.this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        httputil.sendHttpRequest(API.wenti, "stuNum=" + LoginActivity.getAcount() + "&idNum=" + LoginActivity.getPassword() + "&question_id=" + id, new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                JSONObject jsonObjectq = new JSONObject(response);
                JSONArray jsonArrayq = jsonObjectq.getJSONArray("answers");
                int status = jsonObjectq.getInt("status");
                Log.d(TAG, String.valueOf(status));
                answerData = getAnswer(jsonArrayq);
                answeradapter=new Answeradapter(answerData,integerList,WentiActivity.this);
                handler.sendEmptyMessage(START_NEWS1);
            }
        });

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    QustionData qustionData1 = (QustionData) message.obj;
                    //ImageLoader.build(context).setImagePlace(R.drawable.ic_launcher_background)
                           // .setBitmap(qustionData1.getImage(), imageView);
                    nicker.setText(qustionData1.getNicker());
                    if (qustionData1.getGender().equals("男")) {
                        gender.setImageResource(R.drawable.man);
                    } else {
                        gender.setImageResource(R.drawable.girl);
                    }
                    title.setText(qustionData1.getTitle());
                    description.setText(qustionData1.getDescription());
                    creat.setText(qustionData1.getCreated_at());
                    break;
                case 2:
                    List<String> stringList = (List<String>) message.obj;
                    //ImageLoader.build(context).setImagePlace(R.drawable.jiahao)
                        //    .setBitmap(stringList.get(0),imageView1);
                    imageLoader.displayImage(stringList.get(0),imageView1);
if(stringList.get(1)!=null){
    //ImageLoader.build(context).setImagePlace(R.drawable.jiahao)
        //    .setBitmap(stringList.get(1),imageView2);
    imageLoader.displayImage(stringList.get(1),imageView2);
}
break;
                case START_NEWS1:
                    mRecyclerView.setAdapter(answeradapter);
                    break;
                case REFRESHED1:
                    mRefreshLayout.setRefreshing(false);
                    answeradapter.notifyDataSetChanged();
                    // mRecyclerView.setAdapter(answeradapter);
                    break;
            }
        }
    };

        public void get() {

            httputil.sendHttpRequest(API.wenti, "stuNum=" + LoginActivity.getAcount() + "&idNum=" + LoginActivity.getPassword() + "&question_id=" + id, new httputil.Callback() {
                @Override
                public void onResponse(String response) throws JSONException {
                    JSONObject object = new JSONObject(response);
                    int status = object.getInt("status");
                    if (status == 200) {
                        JSONObject jsonObject = object.getJSONObject("data");
                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");
                        int reward = jsonObject.getInt("reward");
                        String disa = jsonObject.getString("disappear_at");
                        String nicker = jsonObject.getString("questioner_nickname");
                        String picture = jsonObject.getString("questioner_photo_thumbnail_src");
                        String gender = jsonObject.getString("questioner_gender");
                        JSONArray pic = jsonObject.getJSONArray("photo_urls");
                        if (pic.length() > 0) {
                            List<String> list = new ArrayList();
                            for (int j = 0; j < 2; j++) {
                                String s = pic.getString(j).toString();
                                list.add(s);
                                Message message = Message.obtain();
                                message.obj = list;
                                message.what = 2;
                                handler.sendMessage(message);
                            }
                        }
                        QustionData qustionData = new QustionData(title, description, gender, disa, id, picture, nicker);
                        Message msg = Message.obtain();
                        msg.obj = qustionData;
                        msg.what = 1;
                        handler.sendMessage(msg);

                    } else {
                        Log.d(TAG, "加载错误");
                    }
                }
            });
        }

        public AnswerData[] getAnswer(JSONArray jsonArray) throws JSONException {
List<AnswerData> mlist = new ArrayList<>();
            for(int j=0;j<jsonArray.length();j++){
                int id = jsonArray.getJSONObject(j).getInt("id");
                integerList.add(id);
                String nickern = jsonArray.getJSONObject(j).getString("nickname");
                String photo = jsonArray.getJSONObject(j).getString("photo_thumbnail_src");
                String gender = jsonArray.getJSONObject(j).getString("gender");
                String content = jsonArray.getJSONObject(j).getString("content");
                String crae = jsonArray.getJSONObject(j).getString("created_at");
                int pnum = jsonArray.getJSONObject(j).getInt("praise_num");
                int cnum = jsonArray.getJSONObject(j).getInt("comment_num");
                int isa = jsonArray.getJSONObject(j).getInt("is_adopted");
                int isp = jsonArray.getJSONObject(j).getInt("is_praised");
                JSONArray jsonArray1 = jsonArray.getJSONObject(j).getJSONArray("photo_url");
                if(jsonArray1.length()>=1){
                    for(int k=0;k<jsonArray1.length();k++){
                        String s = jsonArray1.getJSONObject(k).toString();
                        stringList.add(s);
                    }
                }
                mlist.add(new AnswerData(nickern,photo,gender,content,crae,pnum,cnum,isa,isp));
            }
            return mlist.toArray(new AnswerData[]{});

        }
    }

