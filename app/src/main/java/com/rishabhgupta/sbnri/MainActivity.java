package com.rishabhgupta.sbnri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rishabhgupta.sbnri.adapter.*;
import com.rishabhgupta.sbnri.viewmodel.DataViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView)findViewById(R.id.rv_data);
        DataViewModel dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getMutableLiveData().observe(this, new Observer<ArrayList<DataViewModel>>() {
            @Override
            public void onChanged(ArrayList<DataViewModel> myListViewModels) {
                adapter = new DataAdapter(myListViewModels,MainActivity.this);
                recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerview.setAdapter(adapter);
            }
        });
    }
}
