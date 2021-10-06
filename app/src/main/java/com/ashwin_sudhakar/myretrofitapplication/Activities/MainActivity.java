package com.ashwin_sudhakar.myretrofitapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ashwin_sudhakar.myretrofitapplication.Adaptor.DataAdaptor;
import com.ashwin_sudhakar.myretrofitapplication.Helpers.ApiClient;
import com.ashwin_sudhakar.myretrofitapplication.LayoutManager.ScaleCenterItemLayoutManager;
import com.ashwin_sudhakar.myretrofitapplication.Model.DataModel;
import com.ashwin_sudhakar.myretrofitapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private DataAdaptor adaptor;
    List<DataModel> dataModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        iniRecyclerView();
        fetchData();
    }

    private void fetchData() {
        mProgressBar.setVisibility(View.VISIBLE);
        ApiClient.getApiClient().getDataModels().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    Log.e("Response",response.toString());
                    dataModelList.addAll(response.body());
                    adaptor.notifyDataSetChanged();
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Error: "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void iniRecyclerView() {

        ScaleCenterItemLayoutManager layoutManager = new ScaleCenterItemLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        mRecyclerView.setLayoutManager(layoutManager);
        adaptor = new DataAdaptor(dataModelList);
        mRecyclerView.setAdapter(adaptor);
    }

    private void initViews() {

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mProgressBar = findViewById(R.id.mProgressBar);
    }
}