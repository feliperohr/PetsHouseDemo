package com.example.petshouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshouse.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private String data1[], data2[], data3[];
    int images[];
    Context context;


    public TaskAdapter(Context context, String[] data1, String[] data2, String[] data3, int[] images) {
        this.context = context;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.task_card, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
        holder.name.setText(data1[pos]);
        holder.date.setText(data2[pos]);
        holder.desc.setText(data3[pos]);
        holder.image.setImageResource(images[pos]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, date, desc;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_task_user_name);
            date = itemView.findViewById(R.id.txt_task_date);
            desc = itemView.findViewById(R.id.txt_task_desc);
            image = itemView.findViewById(R.id.task_avatar_img);
        }
    }
}
