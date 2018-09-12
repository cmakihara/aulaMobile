package com.aulamobile.aulamobile;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private RecyclerView rvList;
    private LinkedList<Tarefa> list;
    private ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getElements();
        createActions();

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        this.rvList.setLayoutManager(linearLayoutManager);


        list = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Tarefa("Tarefa " + i));
        }
        adapter = new ListAdapter(this, list);
        rvList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void createActions() {
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
    }

    private void addTask() {
        final EditText etTask = new EditText(this);
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Tarefa")
                        .setMessage("Add tarefa")
                        .setView(etTask)
                        .setPositiveButton("Salvar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialogInterface,
                                                int i) {
                                Tarefa tarefa = new Tarefa(etTask.getText().toString());
                                list.add(tarefa);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(),
                                        "Salvou!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Cancelar", null)
                        .create();
        dialog.show();

    }

    private void getElements() {
        this.rvList = findViewById(R.id.rvList);
        this.fabAdd = findViewById(R.id.fabAdd);
    }

    public void onClickList(Tarefa tarefa) {
       list.remove(tarefa);
       adapter.notifyDataSetChanged();
    }
}
