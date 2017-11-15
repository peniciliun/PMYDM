package com.example.usuario.chucknorris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.TextView;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView chistetxt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.Btn);
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/%22")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        interfazChistaco request = retrofit.create(interfazChistaco.class);

        Call<chiste> call = request.getChiste();

        call.enqueue(new Callback<chiste>() {
            @Override
            public void onResponse(Call<chiste> call, Response<chiste> response) {

                chiste chistazo = response.body();
                chistetxt = (TextView) findViewById(R.id.txt);

                chistetxt.setText(chistazo.getValue());

            }

            @Override
            public void onFailure(Call<chiste> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            }
        });
    }
}


