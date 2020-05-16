package com.rishabhgupta.sbnri.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabhgupta.sbnri.R;
import com.rishabhgupta.sbnri.databinding.DataBinding;
import com.rishabhgupta.sbnri.viewmodel.*;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<DataViewModel> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public DataAdapter(ArrayList<DataViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        DataBinding dataBinding= DataBindingUtil.inflate(layoutInflater,R.layout.data_item,parent,false);
        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataViewModel DataViewModel = arrayList.get(position);
        holder.bind(DataViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private DataBinding dataBinding;
        public ViewHolder(@NonNull DataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }
        public void bind(DataViewModel data){
            this.dataBinding.setDataModel(data);
            dataBinding.executePendingBindings();
        }
        public DataBinding getDataBinding(){
            return dataBinding;
        }
    }
}
