package com.aulamobile.aulamobile;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{

    private Button btEntrar;
    private TextInputEditText etLogin ,etSenha ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        this.btEntrar = this.findViewById(R.id.btEntrar);
        this.etLogin    = this.findViewById(R.id.etLogin);
        this.etSenha = this.findViewById(R.id.etSenha);

        String login =LoginUtil.get(this);
        if(login != null){
            Toast.makeText(getApplicationContext(),
                    "Ultimo usuario " + login, Toast.LENGTH_SHORT).show();

        }

        this.btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString();
                String senha = etSenha.getText().toString();

                if (login.equals("admin") && senha.equals("1")){

                    LoginUtil.save(getApplicationContext(),login,senha);

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Bloqueado", Toast.LENGTH_SHORT).show();
                    //R.string.bloqueado,
                }

               // finish();
                // Toast.makeText(getApplicationContext(),
                //            "Entrar", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
