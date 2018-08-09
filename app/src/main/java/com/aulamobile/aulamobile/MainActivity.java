package com.aulamobile.aulamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rvList = findViewById(R.id.rvList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.rvList.setLayoutManager(linearLayoutManager);

        List<Tarefa> list = new LinkedList<>();
        for (int i = 0; i < 30; i++){
            list.add(new Tarefa("Tarefa " + i));
        }

        ListAdapter adapter = new ListAdapter(this, list);
        rvList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
