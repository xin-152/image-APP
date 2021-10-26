package com.xin.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;
import java.util.Map;

public class TopRecycleAdapter extends RecyclerView.Adapter<TopRecycleAdapter.myViewHolder> {
    private Context context;
    private List<Map<String,Object>> imagesInfo;

    public TopRecycleAdapter(Context context, List<Map<String,Object>> imagesInfo) {
        this.context = context;
        this.imagesInfo = imagesInfo;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopRecycleAdapter.myViewHolder holder, int position) {
        holder.imageView.setImageResource((Integer) imagesInfo.get(position).get("id"));
        holder.top_number.setImageResource((Integer) imagesInfo.get(position).get("icon"));
        holder.title.setText((String)imagesInfo.get(position).get("title"));
        holder.aurhor.setText("作者："+imagesInfo.get(position).get("author"));
        holder.txt.setText("简介："+imagesInfo.get(position).get("txt"));
    }

    @Override
    public int getItemCount() {
        return imagesInfo.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView aurhor;
        private TextView txt;
        private ImageView top_number;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_top);
            title=itemView.findViewById(R.id.tv_top_title);
            aurhor=itemView.findViewById(R.id.tv_top_author);
            txt=itemView.findViewById(R.id.tv_top_txt);
            top_number=itemView.findViewById(R.id.top_number);
        }
    }
}
