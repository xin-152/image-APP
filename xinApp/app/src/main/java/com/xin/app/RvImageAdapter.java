package com.xin.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<Integer> imagesId;
    public RvImageAdapter(Context context, List<Integer> imagesId) {
        this.context = context;
        this.imagesId = imagesId;
    }

    @NonNull

    @Override
    //创建ViewHolder 返回值是一个ViewHolder 因此后面写了一个ViewHolder内部类
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wf, parent, false);
        holder = new ImageViewHolder(inflate);
        return holder;
    }
    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ImageViewHolder) holder).imageview.setImageResource(imagesId.get(position));
        //单击事件
        ((ImageViewHolder) holder).itemBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("item"+position, "onClick:"+imagesId.get(position));
                Intent intent =new Intent(context,show_img.class);
                intent.putExtra("imgID",imagesId.get(position));
                context.startActivity(intent);
                notifyItemInserted(getItemCount());
            }
        });
    }

    @Override
    public int getItemCount() {
        return imagesId != null ? imagesId.size() : 0;
    }

    //在这个内部类中实例化ImageView
    private class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview;
        private View itemBox;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.imageview);
            itemBox=itemView.findViewById(R.id.itemBox);

            int width = ((Activity) imageview.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = imageview.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width/2;
            params.height =  (int) (400 + Math.random() * 400) ;
            imageview.setLayoutParams(params);
        }
    }
}
