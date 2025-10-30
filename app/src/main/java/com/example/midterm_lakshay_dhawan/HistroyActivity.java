package com.example.midterm_lakshay_dhawan;

import static com.example.midterm_lakshay_dhawan.MainActivity.histroyList;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HistroyActivity extends AppCompatActivity {

    ListView listViewHistroy;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histroy);

        listViewHistroy = findViewById(R.id.listViewHistroy);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, histroyList);

        listViewHistroy.setAdapter(adapter);


    }




}
