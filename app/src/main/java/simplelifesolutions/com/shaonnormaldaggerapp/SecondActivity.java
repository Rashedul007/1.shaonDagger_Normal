package simplelifesolutions.com.shaonnormaldaggerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplelifesolutions.com.shaonnormaldaggerapp.adapter.MyRecyclerAdapter;
import simplelifesolutions.com.shaonnormaldaggerapp.adapter.MyRecyclerAdapter2;
import simplelifesolutions.com.shaonnormaldaggerapp.helper.GetRetrofitClient;
import simplelifesolutions.com.shaonnormaldaggerapp.models.RandomUsers;

public class SecondActivity extends AppCompatActivity  {

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter2 mRecyclerAdapter;
    APIInterface retroInterface;
    final String LOG_TAG = "testLogTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();

        String intntGender = getIntent().getStringExtra("extraGender");

        retroInterface = GetRetrofitClient.getClient().create(APIInterface.class);

        Call<RandomUsers> retroCall = retroInterface.getGenderWise(intntGender.toString() , 10);

        retroCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
              Log.d(LOG_TAG, "SUccess:" + response.body().toString());

                mRecyclerAdapter.setItems(response.body().getResults());
                mRecyclerView.setAdapter(mRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Log.d(LOG_TAG, "failed");
                Log.d(LOG_TAG, "MyReason" + t.getCause().toString());
                call.cancel();
            }
        });

    }

    private void initViews()
    {
        mRecyclerView = findViewById(R.id.myRecyclerViewSecond);
        mRecyclerAdapter = new MyRecyclerAdapter2();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
