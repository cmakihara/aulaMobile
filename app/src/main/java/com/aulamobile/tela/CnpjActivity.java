package com.aulamobile.tela;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aulamobile.aulamobile.R;
import com.aulamobile.aulamobile.RetrofitUtil;
import com.aulamobile.entity.Cnpj;
import com.aulamobile.service.CnpjService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CnpjActivity extends AppCompatActivity {

    CnpjService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnpj);

        service = RetrofitUtil.buildCnpj().create(CnpjService.class);

        Button btBuscaCnpj = findViewById(R.id.btBuscaCnpj);
        btBuscaCnpj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cnpj cnpj = new Cnpj();
                EditText campoCnpj = findViewById(R.id.etCnpj);
                cnpj.setCnpj(campoCnpj.getText().toString());
                Call<Cnpj> callBack = service.cnpjDados(cnpj.getCnpj());


                callBack.enqueue(new Callback<Cnpj>() {

                    @Override
                    public void onResponse(Call<Cnpj> call, Response<Cnpj> response) {

                        Cnpj cnpj = response.body();
                        if(cnpj != null){
                            setCep(cnpj);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"CNPJ INVALIDO", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Cnpj> call, Throwable t) {

                    }
                });
            }
        });
    }

    private void setCep(Cnpj cnpj) {
//        EditText campoAtividade = findViewById(R.id.etAtividade);
//        campoAtividade.setText(cnpj.getAtividade_principal());

        EditText campoNome = findViewById(R.id.etNome);
        campoNome.setText(cnpj.getNome());

        EditText campoUf = findViewById(R.id.etUf);
        campoUf.setText(cnpj.getUf());

        EditText campoTelefone = findViewById(R.id.etTelefone);
        campoTelefone.setText(cnpj.getTelefone());

        EditText campoEmail = findViewById(R.id.etEmail);
        campoEmail.setText(cnpj.getEmail());

        EditText campoSituacao = findViewById(R.id.etSituacao);
        campoSituacao.setText(cnpj.getSituacao());

        EditText campoBairro = findViewById(R.id.etBairro);
        campoBairro.setText(cnpj.getBairro());

        EditText campoLogradouro = findViewById(R.id.etLogradouro);
        campoLogradouro.setText(cnpj.getLogradouro());

        EditText campoCep = findViewById(R.id.etCep);
        campoCep.setText(cnpj.getCep());

        EditText campoMunicipio = findViewById(R.id.etMunicipio);
        campoMunicipio.setText(cnpj.getMunicipio());

        EditText campoFantasia = findViewById(R.id.etNomeFantasia);
        campoFantasia.setText(cnpj.getFantasia());

        EditText campoCapitalSocial = findViewById(R.id.etCapitalSocial);
        campoCapitalSocial.setText(cnpj.getCapital_social());

    }
}
//Toast.makeText(getApplicationContext(), callBack., Toast.LENGTH_SHORT).show();
