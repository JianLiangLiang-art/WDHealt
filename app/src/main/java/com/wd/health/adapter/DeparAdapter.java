package com.wd.health.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.app.App;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.view.activity.DetailsActivity;
import com.wd.health.view.activity.SickCircleInfoActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class DeparAdapter extends RecyclerView.Adapter<DeparAdapter.ViewHolder> {
    private Context context;
    private List<DepartmentsBean.ResultBean> list;

    public DeparAdapter() {
    }

    public interface liangId{
        void liang(String s,int id);
    }

    public liangId liangId;

    public void setLiangId(DeparAdapter.liangId liangId) {
        this.liangId = liangId;
    }

    public DeparAdapter(Context context, List<DepartmentsBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.depar_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DepartmentsBean.ResultBean resultBean = list.get(i);
        viewHolder.textView.setText(resultBean.getDepartmentName());
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.textView.setTextColor(Color.GREEN);
            }
        });
        if (viewHolder.textView.isTextSelectable()){
            viewHolder.textView.setTextColor(Color.GREEN);
        }
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = viewHolder.textView.getText().toString();
               liangId.liang(s,list.get(i).getId());

            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SickCircleInfoActivity.class);
                intent.putExtra("sickCircleId", "4");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.depar_name);
        }
    }


}
