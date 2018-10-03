package com.aulamobile.aulamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep);

        CepService service = RetrofitUtil.build().create(CepService.class);

        Call<Cep> callBack = service.cepDados("85810220/json");

        callBack.enqueue(new Callback<Cep>() {

            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                Cep cep = response.body();
                setCep(cep);
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {

            }
        });
    }

    private void setCep(Cep cep) {
        //Toast.makeText(getApplicationContext(), cep.getBairro(), Toast.LENGTH_SHORT).show();


    }
}
//Toast.makeText(getApplicationContext(), callBack., Toast.LENGTH_SHORT).show();
