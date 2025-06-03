package com.example.expensetracker.Adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.expensetracker.Domain.TrendSDomain;
import com.example.expensetracker.R;

import java.util.ArrayList;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.Viewholder> {

    ArrayList<TrendSDomain> itmes;
    Context context;

    public TrendsAdapter(ArrayList<TrendSDomain> itmes) {
        this.itmes = itmes;
    }

    @NonNull
    @Override
    public TrendsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflator= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_trend_list,parent,false);
        context= parent.getContext();
        return new Viewholder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.title.setText(itmes.get(position).getTitle());
        holder.subtitle.setText(itmes.get(position).getSubtitle());

        int drawableResourseId=holder.itemView.getResources().getIdentifier(itmes.get(position).getPicAddress(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourseId)
                    .transform(new GranularRoundedCorners(30,30,0,0))
                    .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return itmes.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title,subtitle;
        ImageView pic;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            subtitle=itemView.findViewById(R.id.subtitleTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
