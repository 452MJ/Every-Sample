package com.example.administrator.every_sample.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.every_sample.R;
import com.example.administrator.every_sample.bean.LoginBean;
import com.example.administrator.every_sample.http.api.HttpServiceSamples;
import com.example.administrator.every_sample.http.retrofit.HttpSubscriber;
import com.example.administrator.every_sample.http.RequestParams;
import com.example.administrator.every_sample.http.retrofit.RetrofitHelper;
import com.example.administrator.every_sample.util.GsonParseHelper;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Retrofit retrofit;

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
                Style style = new Style.Builder()
                        .setImageResource(R.mipmap.ic_launcher)
                        .setTextShadowRadius(10)
                        .setGravity(Gravity.CENTER)
                        .build();
                Crouton.makeText((Activity) context, "data: ", style).show();
//                Crouton.make((Activity) context, LayoutInflater.from(context).inflate(R.layout.crouton_view, null), R.id.content).show();
                requestJSON();


            }
        });
    }

    private void requestJSON() {
        RequestParams params = new RequestParams();
        params.addParams("service", "home_school")
                .addParams("platform", "app")
                .addParams("username", "17707418690")
                .addParams("password", "123456");

        LoginBean bean = new LoginBean(0, "message", "token", "url");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonParseHelper.toJson(bean));


        RetrofitHelper.getInstance()
                .create(HttpServiceSamples.class)
//                .DtLogin(params.getParams())
                .json("key", requestBody)
                .compose(RetrofitHelper.<String>handleResult())
                .subscribe(new HttpSubscriber<String>() {
                    @Override
                    public void _onNext(String data) {
                        Crouton.makeText((Activity) context, "data: " + data, Style.INFO).show();
                    }

                    @Override
                    public void _onError(String message) {
                        Crouton.makeText((Activity) context, "error: " + message, Style.INFO).show();
                    }
                });

//        try {
//            Retrofit retrofit = RetrofitHelper.getDefault(RetrofitHelper.BASE_URL);
//
//            Call<MovieBean> call = retrofit.create(HttpServiceSamples.class).getMovie(0, 10);
//            call.enqueue(new Callback<MovieBean>() {
//                @Override
//                public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
//                    Crouton.makeText((Activity) context, response.body().getTitle(), Style.INFO).show();
//                    Log.d("onResponse", "onResponse");
//                }
//
//                @Override
//                public void onFailure(Call<MovieBean> call, Throwable t) {
//                    Log.d("_onError", "_onError");
//                }
//            });
//        }catch (Exception e){
//
//        }

    }
}
