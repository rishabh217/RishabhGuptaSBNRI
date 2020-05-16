package com.rishabhgupta.sbnri.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rishabhgupta.sbnri.R;
import com.rishabhgupta.sbnri.api.*;
import com.rishabhgupta.sbnri.model.*;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {

    public String open_issues_count = "";
    public String name = "";
    public String description = "";
    public MutableLiveData<ArrayList<DataViewModel>>mutableLiveData = new MutableLiveData<>();
    private ArrayList<DataViewModel>arrayList;
    private ArrayList<Data> dataList;

    public DataViewModel(){

    }

    public DataViewModel(Data data){
        this.open_issues_count = data.open_issues_count;
        this.name = data.name;
        this.description =data.description;
    }

    public MutableLiveData<ArrayList<DataViewModel>> getMutableLiveData() {

        arrayList = new ArrayList<>();

        DataApi api= DataRetrofit.getInstance().getDataApi();
        Call<ArrayList<Data>>call=api.getDataList();
        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                dataList = new ArrayList<>();
                dataList = response.body();
                for (int i=0; i<dataList.size(); i++){
                    Data myk = dataList.get(i);
                    DataViewModel dataViewModel = new DataViewModel(myk);
                    arrayList.add(dataViewModel);
                    mutableLiveData.setValue(arrayList);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
