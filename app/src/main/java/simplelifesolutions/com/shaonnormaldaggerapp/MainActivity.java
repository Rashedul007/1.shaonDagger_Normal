package simplelifesolutions.com.shaonnormaldaggerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import simplelifesolutions.com.shaonnormaldaggerapp.adapter.MyRecyclerAdapter;
import simplelifesolutions.com.shaonnormaldaggerapp.helper.GetRetrofitClient;
import simplelifesolutions.com.shaonnormaldaggerapp.models.RandomUsers;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.ClickListener {

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    APIInterface retroInterface;
    final String LOG_TAG = "testLogTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    //    retroInterface = getClient().create(APIInterface.class);
       retroInterface = GetRetrofitClient.getClient().create(APIInterface.class);

        Call<RandomUsers> retroCall = retroInterface.getPeople(10);

        retroCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
//                Log.d(LOG_TAG, "SUccess:" + response.body().toString());

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
        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void funcLaunchIntent(String strGender) {
        Toast.makeText(this, strGender, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("extraGender", strGender));
    }

}
