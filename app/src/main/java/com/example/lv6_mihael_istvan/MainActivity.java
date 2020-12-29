package com.example.lv6_mihael_istvan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RemoveClickListener{

    private RecyclerView recycler;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
    }

    private void setupRecycler(){
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }

    private void setupRecyclerData(){
        List<String> data = new ArrayList<>();
        data.add("Kupi kruh");
        data.add("Nahrani macku");
        data.add("Upisi diplomski");
        adapter.addData(data);
    }

    public void addCell(View view) {
        EditText editText = findViewById(R.id.newCellName);
        String cellName = editText.getText().toString();
        if (TextUtils.isEmpty(cellName)) {
            Toast.makeText(this, "Please write item name!", Toast.LENGTH_SHORT).show();
        } else {
            adapter.addNewCell(cellName, 0);
        }
    }

    @Override
    public void onRemoveClick(int position) {
        adapter.removeCell(position);
        Toast.makeText(this, "Removed item from position: " + position, Toast.LENGTH_SHORT).show();
    }
}