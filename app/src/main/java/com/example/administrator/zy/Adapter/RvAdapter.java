package com.example.administrator.zy.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.zy.Data.QustionData;
import com.example.administrator.zy.ImageLoder.DoubleCache;
import com.example.administrator.zy.ImageLoder.ImageLoader;
import com.example.administrator.zy.Interface.OnRecyclerviewItemClickListener;
import com.example.administrator.zy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> implements View.OnClickListener {
    private QustionData[] list;
     Context context;
    private ImageLoader imageLoader;

    private OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener = null;

    List<Integer> ids = new ArrayList<>();
    public RvAdapter(QustionData[] mlist, List<Integer> alist, Context mcontext, OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener){
        list = mlist;
        ids = alist;
        context = mcontext;
        imageLoader = new ImageLoader();
        DoubleCache doubleCache = new DoubleCache(context);
        imageLoader.setImageCache(doubleCache);

        this.mOnRecyclerviewItemClickListener = mOnRecyclerviewItemClickListener;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView creat_at;
        ImageView gender;
        TextView description;
        ImageView imageView;
        TextView nicjer;



        public ViewHolder(View itemView) {
            super(itemView);
nicjer = (TextView)itemView.findViewById(R.id.nicker);
            title = (TextView) itemView.findViewById(R.id.title);
            creat_at = (TextView) itemView.findViewById(R.id.jifen);
            gender = (ImageView)itemView.findViewById(R.id.gender);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.avatar);
        }


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,parent,false);
view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int position){
        QustionData qustionData = list[position];
        holder.title.setText(qustionData.getTitle());
        holder.description.setText(qustionData.getDescription());
        //holder.nicker.setText(qustionData.getNicker());
        if(qustionData.getNicker().equals("男")){
            holder.gender.setImageResource(R.drawable.man);
        }
        else {
            holder.gender.setImageResource(R.drawable.girl);
        }
        holder.nicjer.setText(qustionData.getNicker());
        holder.creat_at.setText(qustionData.getCreated_at());
        //ImageLoader.build(context).setImagePlace(R.drawable.ic_launcher_background)
          //      .setBitmap(qustionData.getImage(),holder.imageView);
imageLoader.displayImage(qustionData.getImage(),holder.imageView);
        holder.itemView.setTag(ids.get(position));
        }
        public int getItemCount(){
        return list.length;
        }
    @Override
        public void onClick(View v) {
        //将监听传递给自定义接口
        mOnRecyclerviewItemClickListener.onItemClickListener(v, ((int) v.getTag()));
    }
    }

