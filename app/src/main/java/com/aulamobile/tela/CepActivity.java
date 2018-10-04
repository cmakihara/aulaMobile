package com.aulamobile.tela;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aulamobile.aulamobile.R;
import com.aulamobile.aulamobile.RetrofitUtil;
import com.aulamobile.service.CepService;
import com.aulamobile.entity.Cep;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CepActivity extends AppCompatActivity {

    CepService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep);

        service = RetrofitUtil.buildCep().create(CepService.class);

        Button btBuscaCep = findViewById(R.id.btBuscaCep);
        btBuscaCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cep cep = new Cep();
                EditText campoCep = findViewById(R.id.etCep);
                cep.setCep(campoCep.getText().toString());
                Call<Cep> callBack = service.cepDados(cep.getCep());

                callBack.enqueue(new Callback<Cep>() {

                    @Override
                    public void onResponse(Call<Cep> call, Response<Cep> response) {
                        //   Toast.makeText(getApplicationContext(), response.body().getBairro(), Toast.LENGTH_LONG).show();
                        Cep cep = response.body();
                        if(cep != null){
                            setCep(cep);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"CEP INVALIDO", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Cep> call, Throwable t) {

                    }
                });


            }
        });


    }

    private void setCep(Cep cep) {
        EditText campoRua  = findViewById(R.id.etLogradouro);
        campoRua.setText(cep.getLogradouro());

        EditText campoComplemento = findViewById(R.id.etComplemento);
        campoComplemento.setText(cep.getComplemento());

        EditText campoBairro = findViewById(R.id.etBairro);
        campoBairro.setText(cep.getBairro());

        EditText campoLocalidade = findViewById(R.id.etLocalidade);
        campoLocalidade.setText(cep.getLocalidade());

        EditText campoUf = findViewById(R.id.etUf);
        campoUf.setText(cep.getUf());

        EditText campoIbge = findViewById(R.id.etIbge);
        campoIbge.setText(cep.getIbge());



    }
}
//Toast.makeText(getApplicationContext(), callBack., Toast.LENGTH_SHORT).show();
