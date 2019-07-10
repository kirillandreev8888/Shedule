package com.example.user.shedule2v2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String[] items1;
    String[] items2;
    int[] images;
    public RecyclerViewAdapter (Context context, String[] items1, String[] items2, int[] images){
        this.context = context;
        this.items1 = items1;
        this.items2 = items2;
        this.images = images;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.recycler_layout, viewGroup, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((Item)viewHolder).textView1.setText(items1[i]);
        if (items1[i].length()>15)
            ((Item)viewHolder).textView1.setTextSize(24);
        if (items1[i].length()>20)
            ((Item)viewHolder).textView1.setTextSize(22);
        if (items2[i]=="Технопарк, 395" || items2[i]=="Пьем чай"){
            ((Item)viewHolder).textView2.setText(items2[i]);
        }else{
            ((Item)viewHolder).textView2.setText("Аудитория "+items2[i]);
        }

        ((Item)viewHolder).imageView.setImageResource(images[i]);
        ((Item)viewHolder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean tea = false;
                if (items2[i]=="Пьем чай")
                    tea = true;
                Toast toast = Toast.makeText(context, ded.kogdapara(i, tea), Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items1.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        ImageView imageView;
        LinearLayout linearLayout;
        public Item(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.recyclerImage);
            textView1 = (TextView) itemView.findViewById(R.id.recyclerText1);
            textView2 = (TextView) itemView.findViewById(R.id.recyclerText2);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.recyclerlayout);
        }
    }
}
