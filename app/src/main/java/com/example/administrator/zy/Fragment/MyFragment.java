package com.example.administrator.zy.Fragment;

/**
 * Created by Administrator on 2018/5/27.
 */
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.zy.Activity.LoginActivity;
import com.example.administrator.zy.Data.API;
import com.example.administrator.zy.Data.KeData;
import com.example.administrator.zy.Data.ShowData;
import com.example.administrator.zy.R;
import com.example.administrator.zy.Util.httputil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于创建Fragment对象，作为ViewPager的叶片
 */
public class MyFragment extends Fragment {
    KeData[] keData;
    public final int KE_BIAO = 1;
    List<String> list1 = new ArrayList<>();
private final String TAG = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    TextView data1;
    TextView data2;
    TextView data3;
    TextView data4;
    TextView data5;
    TextView data6;
    TextView data7;
    TextView k11;
    TextView k12;
    TextView k13;
    TextView k14;
    TextView k15;
    TextView k21;
    TextView k22;
    TextView k23;
    TextView k24;
    TextView k25;
    TextView k31;
    TextView k32;
    TextView k33;
    TextView k34;
    TextView k35;
    TextView k41;
    TextView k42;
    TextView k43;
    TextView k44;
    TextView k45;
    TextView k51;
    TextView k52;
    TextView k53;
    TextView k54;
    TextView k55;
    CardView c11;
    CardView c12;
    CardView c13;
    CardView c14;
    CardView c15;
    CardView c21;
    CardView c22;
    CardView c23;
    CardView c24;
    CardView c25;
    CardView c31;
    CardView c32;
    CardView c33;
    CardView c34;
    CardView c35;
    CardView c41;
    CardView c42;
    CardView c43;
    CardView c44;
    CardView c45;
    CardView c51;
    CardView c52;
    CardView c53;
    CardView c54;
    CardView c55;
    int mNum; //页号
    List<TextView> textViewList = new ArrayList<>();
    List<CardView> cardViewList = new ArrayList<>();


        public static MyFragment newInstance(int num) {
            MyFragment fragment = new MyFragment();
            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("num", num);
            fragment.setArguments(args);
            return fragment;
        }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里我只是简单的用num区别标签，其实具体应用中可以使用真实的fragment对象来作为叶片
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;

    }

    /**为Fragment加载布局时调用**/
    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, null);
        TextView tv = (TextView) view.findViewById(R.id.zhoushu);
        k11 = (TextView)view.findViewById(R.id.tt01);
        k12 = (TextView)view.findViewById(R.id.tt02);
        k13 = (TextView)view.findViewById(R.id.tt03);
        k14 = (TextView)view.findViewById(R.id.tt04);
        k15 = (TextView)view.findViewById(R.id.tt05);
        k21 = (TextView)view.findViewById(R.id.tt6);
        k22 = (TextView)view.findViewById(R.id.tt7);
        k23 = (TextView)view.findViewById(R.id.tt8);
        k24 = (TextView)view.findViewById(R.id.tt9);
        k25 = (TextView)view.findViewById(R.id.tt10);
        k31 = (TextView)view.findViewById(R.id.tt11);
        k32 = (TextView)view.findViewById(R.id.tt12);
        k33 = (TextView)view.findViewById(R.id.tt13);
        k34 = (TextView)view.findViewById(R.id.tt14);
        k35 = (TextView)view.findViewById(R.id.tt15);
        k41 = (TextView)view.findViewById(R.id.tt16);
        k42 = (TextView)view.findViewById(R.id.tt17);
        k43 = (TextView)view.findViewById(R.id.tt18);
        k44 = (TextView)view.findViewById(R.id.tt19);
        k45 = (TextView)view.findViewById(R.id.tt20);
        k51 = (TextView)view.findViewById(R.id.tt21);
        k52 = (TextView)view.findViewById(R.id.tt22);
        k53 = (TextView)view.findViewById(R.id.tt23);
        k54 = (TextView)view.findViewById(R.id.tt24);
        k55 = (TextView)view.findViewById(R.id.tt25);
        c11 = (CardView)view.findViewById(R.id.caa01);
        c12 = (CardView)view.findViewById(R.id.caa02);
        c13 = (CardView)view.findViewById(R.id.caa03);
        c14 = (CardView)view.findViewById(R.id.caa04);
        c15 = (CardView)view.findViewById(R.id.caa05);
        c21 = (CardView)view.findViewById(R.id.caa6);
        c22 = (CardView)view.findViewById(R.id.caa7);
        c23 = (CardView)view.findViewById(R.id.caa8);
        c24 = (CardView)view.findViewById(R.id.caa9);
        c25 = (CardView)view.findViewById(R.id.caa10);
        c31 = (CardView)view.findViewById(R.id.caa11);
        c32 = (CardView)view.findViewById(R.id.caa12);
        c33 = (CardView)view.findViewById(R.id.caa13);
        c34 = (CardView)view.findViewById(R.id.caa14);
        c35 = (CardView)view.findViewById(R.id.caa15);
        c41 = (CardView)view.findViewById(R.id.caa16);
        c42 = (CardView)view.findViewById(R.id.caa17);
        c43 = (CardView)view.findViewById(R.id.caa18);

        c44 = (CardView)view.findViewById(R.id.caa19);
        c45 = (CardView)view.findViewById(R.id.caa20);
        c51 = (CardView)view.findViewById(R.id.caa21);
        c52 = (CardView)view.findViewById(R.id.caa22);
        c53 = (CardView)view.findViewById(R.id.caa23);
        c54 = (CardView)view.findViewById(R.id.caa24);
        c55 = (CardView)view.findViewById(R.id.caa25);

        textViewList.add(k11);
        textViewList.add(k12);
        textViewList.add(k13);
        textViewList.add(k14);
        textViewList.add(k15);
        textViewList.add(k21);
        textViewList.add(k22);
        textViewList.add(k23);
        textViewList.add(k24);
        textViewList.add(k25);
        textViewList.add(k31);
        textViewList.add(k32);
        textViewList.add(k33);
        textViewList.add(k34);
        textViewList.add(k35);
        textViewList.add(k41);
        textViewList.add(k42);
        textViewList.add(k43);
        textViewList.add(k44);
        textViewList.add(k45);
        textViewList.add(k51);
        textViewList.add(k52);
        textViewList.add(k53);
        textViewList.add(k54);
        textViewList.add(k55);

        cardViewList.add(c11);
        cardViewList.add(c12);
        cardViewList.add(c13);
        cardViewList.add(c14);
        cardViewList.add(c15);
        cardViewList.add(c21);
        cardViewList.add(c22);
        cardViewList.add(c23);
        cardViewList.add(c24);
        cardViewList.add(c25);
        cardViewList.add(c31);
        cardViewList.add(c32);
        cardViewList.add(c33);
        cardViewList.add(c34);
        cardViewList.add(c35);
        cardViewList.add(c41);
        cardViewList.add(c42);
        cardViewList.add(c43);
        cardViewList.add(c44);
        cardViewList.add(c45);
        cardViewList.add(c51);
        cardViewList.add(c52);
        cardViewList.add(c53);
        cardViewList.add(c54);
        cardViewList.add(c55);
        tv.setText("第"+ mNum+"周");
        getweek(mNum);

        httputil.sendHttpRequest(API.kebiao, "stu_num=" + LoginActivity.getAcount() + "&forceFetch=false", new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                keData = get(response);
                getActivity().runOnUiThread(new Runnable() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void run() {
//更新UI的操作

                List<ShowData> showDataList = new ArrayList<>();
                for(int s=0;s<keData.length;s++){
                                    int id1 = getid(keData[s]);
                                    String lessonq = keData[s].getLesson();
                                    int  jiaoshia = keData[s].getJiaoshi();
                                    showDataList.add(new ShowData(id1,lessonq,jiaoshia));

                                }
                for(int a=0;a<showDataList.size();a++){
                                    textViewList.get(a).setText(showDataList.get(a).getLessonii()+"@"+showDataList.get(a).getJiaoshiii());
                    Log.d(TAG, showDataList.get(a).getLessonii());
                    Log.d(TAG, showDataList.get(a).getLessonii());
                    Log.d(TAG, showDataList.get(a).getLessonii());
                                }

                    }
                });

            }
        });
        Log.d(TAG, "aa");
        return view;
    }

    public KeData[] get(String response) throws JSONException {

      List<KeData> keDataList = new ArrayList<>();
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for(int l=0;l<jsonArray.length();l++){
                    String day=jsonArray.getJSONObject(l).getString("day");
                    String lesson = jsonArray.getJSONObject(l).getString("lesson");
                    String couse = jsonArray.getJSONObject(l).getString("course");
                    String teacher = jsonArray.getJSONObject(l).getString("teacher");
                    int  claaroom = jsonArray.getJSONObject(l).getInt("classroom");
                    String rawWeek = jsonArray.getJSONObject(l).getString("rawWeek");
                    keDataList.add(new KeData(couse,teacher,claaroom,day,lesson,"bixiu",rawWeek));

                }

        return keDataList.toArray(new KeData[]{});
    }
    public int  getid(KeData keData){
        int id = 0;
        if(keData.getWeek().equals("星期一")){
            if(keData.getLesson().equals("一二节"))
                id=1;
            else if(keData.getLesson().equals("三四节"))
                id=2;
            else if(keData.getLesson().equals("五六节"))
                id=3;
            else if(keData.getLesson().equals("七八节"))
                id=4;
            else
                id=5;
        }else if(keData.getWeek().equals("星期二")) {
            if (keData.getLesson().equals("一二节"))
                id = 6;
            else if (keData.getLesson().equals("三四节"))
                id = 7;
            else if (keData.getLesson().equals("五六节"))
                id = 8;
            else if (keData.getLesson().equals("七八节"))
                id = 9;
            else
                id = 10;
        }else if(keData.getWeek().equals("星期三")) {
            if (keData.getLesson().equals("一二节"))
                id = 11;
            else if (keData.getLesson().equals("三四节"))
                id = 12;
            else if (keData.getLesson().equals("五六节"))
                id = 13;
            else if (keData.getLesson().equals("七八节"))
                id = 14;
            else
                id = 15;
        }else if(keData.getWeek().equals("星期四")) {
            if (keData.getLesson().equals("一二节"))
                id = 16;
            else if (keData.getLesson().equals("三四节"))
                id = 17;
            else if (keData.getLesson().equals("五六节"))
                id = 18;
            else if (keData.getLesson().equals("七八节"))
                id = 19;
            else
                id = 20;
        }else if(keData.getWeek().equals("星期二")) {
            if (keData.getLesson().equals("一二节"))
                id = 21;
            else if (keData.getLesson().equals("三四节"))
                id = 22;
            else if (keData.getLesson().equals("五六节"))
                id = 23;
            else if (keData.getLesson().equals("七八节"))
                id = 24;
            else
                id = 25;
        }
        return id;
    }
    public void getweek(final int i){
        final List<String> integerList = new ArrayList<>();
        httputil.sendHttpRequest(API.kebiao, "stu_num=" + LoginActivity.getAcount() + "&forceFetch=false", new httputil.Callback() {
            @Override
            public void onResponse(String response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
for(int i=0;i<jsonArray.length();i++){
    String p = jsonArray.getJSONObject(i).toString();
   integerList.add(p);

}
if(integerList.contains(i+"")){
list1.add(integerList.get(i));

}

            }
        });
    }
}