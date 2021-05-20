package com.example.javabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String>titleList;
    private CustomItemClickListener clickListener;


    public TitleAdapter(Context context, ArrayList<String> titleList, CustomItemClickListener clickListener) {
        this.context = context;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }


        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.title_layout,parent,false );
            final MyViewHolder viewHolder= new MyViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(view, viewHolder.getPosition());

                }
            });

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.titleText.setText(titleList.get(position).replace("_", " "));
    

        }

        @Override
        public int getItemCount() {
            return titleList.size();
        }
        public  class MyViewHolder extends RecyclerView.ViewHolder{
            TextView titleText;
            public MyViewHolder(View itemView)
            {
                super(itemView);
                titleText=(TextView)itemView.findViewById(R.id.title_text);

            }
        }
    }

