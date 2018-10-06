package com.aulamobile.tela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.aulamobile.aulamobile.R;
import com.aulamobile.aulamobile.RetrofitUtil;
import com.aulamobile.entity.Feriado;
import com.aulamobile.service.FeriadoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeriadoActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feriado);

        listView = findViewById(R.id.listView);

        Button buttonFeriado = findViewById(R.id.btIbge);
        buttonFeriado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeriadoService service = RetrofitUtil.buildFeriado().create(FeriadoService.class);
                EditText campoFeriadoIbge = findViewById(R.id.etFeriadoIbge);

                /**
                 * TODO
                 * Não aceita ?
                 * "?json=true&ano=2017&ibge="
                 */
                Call<List<Feriado>> listCallBack = service.listFeriados("?json=true&ano=2017&ibge=3550308");
                listCallBack.enqueue(new Callback<List<Feriado>>() {
                    @Override
                    public void onResponse(Call<List<Feriado>> call, Response<List<Feriado>> response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                        List<Feriado> feriados = response.body();

                        if (feriados != null) {
                            setListView(feriados);
                        } else {
                       //     Toast.makeText(getApplicationContext(), "Repositorio invalido", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Feriado>> call, Throwable t) {

                    }
                });
            }
        });
    }

    public void setListView(List<Feriado> list) {

        if (list != null) {
            String[] values = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                values[i] = list.get(i).getName();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
            listView.setAdapter(adapter);
        }

    }

}