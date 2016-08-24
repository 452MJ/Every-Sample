package com.example.administrator.every_sample.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.every_sample.R;
import com.example.administrator.every_sample.bean.BaseBean;
import com.example.administrator.every_sample.http.HttpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Crouton.makeText((Activity) context, "123", Style.INFO, R.id.content).show();
//                Crouton.make((Activity) context, LayoutInflater.from(context).inflate(R.layout.crouton_view, null), R.id.content).show();
                requestJSON();
            }
        });
    }

    private void requestJSON() {
//        RetrofitHelper.getInstance()
//                .create(HttpService.class).login("home_school", "app", "17707418690", "123456")
//                .compose(RetrofitHelper.<LoginBean>handleResult())
//                .subscribe(new HttpSubscriber<LoginBean>() {
//                    @Override
//                    public void onSuccess(LoginBean loginBean) {
//
//                    }
//
//                    @Override
//                    public void onFailure(String message) {
//
//                    }
//                });

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.douban.com/v2/movie/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Call<BaseBean> call = retrofit.create(HttpService.class).login(0, 10);
            call.enqueue(new Callback<BaseBean>() {
                @Override
                public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                    Log.d("onResponse", "onResponse");
                }

                @Override
                public void onFailure(Call<BaseBean> call, Throwable t) {
                    Log.d("onFailure", "onFailure");
                }
            });
        }catch (Exception e){

        }

    }
}
