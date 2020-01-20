package com.kaungmyatmin.haulio.common.baseclass;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        bindViews(itemView);
    }

    protected abstract void bindViews(View view);
    protected abstract void bindData(T t);
}
