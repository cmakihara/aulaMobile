package com.aulamobile.tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aulamobile.aulamobile.R;

public class MenuActivity extends AppCompatActivity {

    private Button buttontGitHub;
    private Button buttontCep;
    private Button buttontFeriado;
    private Button buttontCnpj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.buttontGitHub = this.findViewById(R.id.btGitHub);
        this.buttontCep = this.findViewById(R.id.btCep);
        this.buttontFeriado = this.findViewById(R.id.btFeriado);
        this.buttontCnpj = this.findViewById(R.id.btCnpj);

        this.buttontGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, GitHubActivity.class);
                startActivity(intent);

            }
        });

        this.buttontCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CepActivity.class);
                startActivity(intent);

            }
        });

        this.buttontFeriado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, FeriadoActivity.class);
                startActivity(intent);

            }
        });

        this.buttontCnpj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CnpjActivity.class);
                startActivity(intent);

            }
        });
    }

}