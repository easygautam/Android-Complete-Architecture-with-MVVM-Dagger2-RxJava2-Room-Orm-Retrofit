package com.gautams.pos.view.adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * User Name: gautams2
 * Create Date : 9/25/2018
 */
public class SpinnerAdapter<T> extends ArrayAdapter<T> {


    private List<T> list;

    private Context context;

    private int viewResId;
    private int dropDownViewResId;

    public SpinnerAdapter(@NonNull Context context, int viewResId, int dropDownViewResId) {
        super(context, viewResId);
        this.context = context;
        this.viewResId = viewResId;
        this.dropDownViewResId = dropDownViewResId;
        this.list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(viewResId, parent, false);
        }
        ViewDataBinding bind = DataBindingUtil.bind(convertView);
        bind.setVariable(BR.model, list.get(position));
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(dropDownViewResId, parent, false);
        }
        ViewDataBinding bind = DataBindingUtil.bind(convertView);
        bind.setVariable(BR.model, list.get(position));
        return convertView;
    }


    @BindingAdapter({"bind:viewLayout", "bind:dropdownViewLayout", "bind:list"})
    public static <T> void setAdapter(Spinner spinner, int viewLayout, int dropdownViewLayout, List<T> list) {
        SpinnerAdapter<T> adapter = new SpinnerAdapter<>(spinner.getContext(), viewLayout, dropdownViewLayout);
        adapter.setList(list);
        spinner.setAdapter(adapter);
    }

}
