package com.xin.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class show_img_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<Integer> imagesId;

    public show_img_Adapter(Context context, List<Integer> imagesId) {
        this.context = context;
        this.imagesId = imagesId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wf, parent, false);
        holder = new myViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((myViewHolder) holder).imageview.setImageResource(imagesId.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesId != null ? imagesId.size() : 0;
    }

    private class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview;
        private View itemBox;
        private ImageView showimg_pic;

        public myViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.imageview);
            itemBox=itemView.findViewById(R.id.itemBox);
            showimg_pic=itemView.findViewById(R.id.showimg_pic);

            int width = ((Activity) imageview.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = imageview.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width/2;
            params.height =  width/2;
            imageview.setLayoutParams(params);
        }
    }
}
