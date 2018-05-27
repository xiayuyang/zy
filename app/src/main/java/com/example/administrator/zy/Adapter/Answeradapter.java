package com.example.administrator.zy.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.zy.Data.AnswerData;
import com.example.administrator.zy.ImageLoder.DoubleCache;
import com.example.administrator.zy.ImageLoder.ImageLoader;
import com.example.administrator.zy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/26.
 */

public class Answeradapter extends RecyclerView.Adapter<Answeradapter.ViewHolder> {
    private AnswerData[] list;
    Context context;
private ImageLoader imageLoader;
    List<Integer> ids = new ArrayList<>();
    public Answeradapter(AnswerData[] mlist, List<Integer> list, Context mcontext){
        this.list = mlist;
        this.ids = list;
        this. context = mcontext;
        imageLoader = new ImageLoader();
        DoubleCache doubleCache = new DoubleCache(context);
        imageLoader.setImageCache(doubleCache);
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
       TextView nicjer;
        TextView creat_at;
        ImageView gender;
        TextView description;
        ImageView imageView;
        TextView praise;
        TextView a;
        TextView isp;
        TextView isa;



        public ViewHolder(View itemView) {
            super(itemView);

            nicjer = (TextView) itemView.findViewById(R.id.nicker2);
            creat_at = (TextView) itemView.findViewById(R.id.jifen1);
            gender = (ImageView)itemView.findViewById(R.id.gender2);
            description = (TextView) itemView.findViewById(R.id.description2);
            imageView = (ImageView) itemView.findViewById(R.id.avatar2);
            praise=(TextView)itemView.findViewById(R.id.but);
        }


    }
    @Override
    public Answeradapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_item,parent,false);
        Answeradapter.ViewHolder holder = new Answeradapter.ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(Answeradapter.ViewHolder holder, int position){
        AnswerData answerData = list[position];
        holder.nicjer.setText(answerData.getNicker());
        holder.description.setText(answerData.getContent());
        holder.praise.setText(answerData.getPrase());
        //holder.nicker.setText(qustionData.getNicker());
        if(AnswerData.getNicker().equals("男")){
            holder.gender.setImageResource(R.drawable.man);
        }
        else {
            holder.gender.setImageResource(R.drawable.girl);
        }
        holder.creat_at.setText(answerData.getCrate());
       // ImageLoader.build(context).setImagePlace(R.drawable.ic_launcher_background)
         //       .setBitmap(AnswerData.getPicture(),holder.imageView);
imageLoader.displayImage(answerData.getPicture(),holder.imageView);
    }
    public int getItemCount(){
        return list.length;
    }

}
