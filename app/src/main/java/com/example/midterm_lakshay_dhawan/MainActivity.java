package com.example.midterm_lakshay_dhawan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button  button, btnHistroy;
    ListView listView;

    ArrayList<String> tableList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    static ArrayList<String> histroyList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        btnHistroy = findViewById(R.id.btnHistroy);
        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableList);
        listView.setAdapter(adapter);

        button.setOnClickListener(v -> generateTableList());
        btnHistroy.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistroyActivity.class);
            startActivity(intent);
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Delete Item")
                    .setMessage("Delete this item?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        tableList.remove(selectedItem);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", null)
                    .show();
            });

    }

    private void generateTableList() {
        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        tableList.clear();
        for (int i = 1; i <= 10; i++) {
            tableList.add(number + " x " + i + " = " + (number * i));
        }
        adapter.notifyDataSetChanged();

        if (!histroyList.contains(input)) {
            histroyList.add(input);
        }
    }

}