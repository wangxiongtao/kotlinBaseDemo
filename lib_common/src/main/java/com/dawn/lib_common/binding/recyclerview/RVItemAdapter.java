package com.dawn.lib_common.binding.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public abstract class RVItemAdapter<T> extends RecyclerView.Adapter<RVItemAdapter.ViewHolder> {
    protected List<T> dataList;
    private LayoutInflater mLayoutInflater;

    public void setList(List<T> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mLayoutInflater==null){
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, getLayoutId(viewType), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        if (binding == null) {
            return;
        }
        T data = null;
        if (position < dataList.size()) {
            data = dataList.get(position);
        }
        onBindViewHolder(binding, data, position);
        binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public abstract int getLayoutId(int viewType);

    public abstract void onBindViewHolder(ViewDataBinding binding, T item, int position);
}
