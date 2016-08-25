package com.example.administrator.every_sample.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.every_sample.R;
import com.example.administrator.every_sample.http.HttpService;
import com.example.administrator.every_sample.http.HttpSubscriber;
import com.example.administrator.every_sample.http.RetrofitHelper;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
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

//                Crouton.make((Activity) context, LayoutInflater.from(context).inflate(R.layout.crouton_view, null), R.id.content).show();
                requestJSON();


            }
        });
    }

    private void requestJSON() {

        RetrofitHelper.getInstance()
                .create(HttpService.class).login()
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
//            Call<MovieBean> call = retrofit.create(HttpService.class).getMovie(0, 10);
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
