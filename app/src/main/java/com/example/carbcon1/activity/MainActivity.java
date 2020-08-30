package com.example.carbcon1.activity;

import android.os.Bundle;
import com.example.carbcon1.model.Notice;
import com.example.carbcon1.adapter.NoticeAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import android.util.Log;
import com.example.carbcon1.my_interface.GetNoticeDataService;

import androidx.appcompat.widget.Toolbar;

import com.example.carbcon1.model.NoticeList;

import com.example.carbcon1.R;
//import com.example.carbcon1.RetroUsers;
import com.example.carbcon1.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity{

        private NoticeAdapter adapter;
        private RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            /** Create handle for the RetrofitInstance interface*/
            GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

            /** Call the method with parameter in the interface to get the notice data*/
            Call<NoticeList> call = service.getNoticeData();

            /**Log the URL called*/
            Log.wtf("URL Called", call.request().url() + "");

            call.enqueue(new Callback<NoticeList>() {
                @Override
                public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                    generateNoticeList(response.body().getNoticeArrayList());
                }

                @Override
                public void onFailure(Call<NoticeList> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        /** Method to generate List of notice using RecyclerView with custom adapter*/
        private void generateNoticeList(ArrayList<Notice> noticeArrayList) {
            recyclerView = findViewById(R.id.recycler_view_notice_list);
            adapter = new NoticeAdapter(noticeArrayList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

}

