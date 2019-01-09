package com.hxc.supreme.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hxc.supreme.R;

import java.util.List;

/**
 * created by huxc  on 2017/11/28.
 * func：
 * email: hxc242313@qq.com
 */

public class VerRecycleAdapter extends RecyclerView.Adapter<VerRecycleAdapter.MyViewHolder> {
    private List<String> data;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public VerRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VerRecycleAdapter.MyViewHolder holder = new VerRecycleAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ver_recycleview, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final VerRecycleAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position));
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return  data == null ? 0 : data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
        }
    }


    public void addData(int position) {
        data.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }
}
