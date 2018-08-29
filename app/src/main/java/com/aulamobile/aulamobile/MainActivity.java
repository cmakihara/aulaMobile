package com.aulamobile.aulamobile;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private RecyclerView rvList;
    private LinkedList<Tarefa> list;
    private ListAdapter adapter;
    private JSONArray array = new JSONArray();
    private JSONObject obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rvList = findViewById(R.id.rvList);
        this.fabAdd = findViewById(R.id.fabAdd);


        getElements();
        createActions();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.rvList.setLayoutManager(linearLayoutManager);


        list = new LinkedList<>();



        adapter = new ListAdapter(this, list);
        rvList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void createActions() {
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Clicou", Toast.LENGTH_SHORT).show();
                addTask();

            }
        });
    }

    private void addTask() {
        final EditText etTask = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Tarefa")
                .setMessage("Add Tarefa")
                .setView(etTask)
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int i) {
                        Tarefa tarefa = new Tarefa(etTask.getText().toString());
                        list.add(tarefa);


                        obj = new JSONObject();

                        try {
                            obj.put("nome", tarefa.getTarefa());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                        array.put(obj);

                        String arrayStr = array.toString();

                        SharedPreferences sharedPreferences = getSharedPreferences(String.valueOf(tarefa), MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("tarefa", arrayStr).commit();

                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Salvou", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", null). create();
        dialog.show();

    }



    private void getElements() {
        this.rvList = findViewById(R.id.rvList);
        this.fabAdd = findViewById(R.id.fabAdd);
    }

    public void onClickList(Tarefa tarefa) {
        Toast.makeText(getApplicationContext(), tarefa.getTarefa(), Toast.LENGTH_SHORT).show();
        list.remove(tarefa);
        adapter.notifyDataSetChanged();
    }
}
