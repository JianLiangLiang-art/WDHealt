package com.wd.health.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.model.bean.SickCircleListBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class SickAdapter extends RecyclerView.Adapter<SickAdapter.ViewHolder> {
    private Context context;
    private List<SickCircleListBean.ResultBean> list;

    public SickAdapter(Context context, List<SickCircleListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sick_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.item_name.setText(list.get(i).getTitle());
        Date date = new Date(list.get(i).getReleaseTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        viewHolder.item_time.setText(simpleDateFormat.format(date));
        viewHolder.item_text.setText(list.get(i).getDetail());
        viewHolder.item_shoucang.setText(list.get(i).getCollectionNum()+"");
        viewHolder.item_jianyi.setText(list.get(i).getCommentNum()+"");
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClick.onitem(list.get(i).getSickCircleId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView item_name,item_time,item_text,item_shoucang,item_jianyi;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.item_linear);
            item_name = itemView.findViewById(R.id.item_name);
            item_time = itemView.findViewById(R.id.item_time);
            item_text = itemView.findViewById(R.id.item_text);
            item_shoucang = itemView.findViewById(R.id.item_shoucang);
            item_jianyi = itemView.findViewById(R.id.item_jianyi);
        }
    }
    SeachAdapter.ItemOnClick itemOnClick;
    public void setItemOnClick(SeachAdapter.ItemOnClick itemOnClick){
        this.itemOnClick = itemOnClick;
    }
    public interface ItemOnClick{
        void onitem(int p);
    }
}
