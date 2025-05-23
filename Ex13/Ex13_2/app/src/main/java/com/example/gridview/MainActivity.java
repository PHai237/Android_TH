package com.example.gridview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView txtView;
    private GridView gridView;
    String [] values = {
            "Ipad",
            "Iphone",
            "New Ipad",
            "SamSung",
            "Nokia",
            "Sonic Ericson",
            "LG",
            "Q-Mobile",
            "HTC",
            "Blackberry",
            "G Phone",
            "FPT - Phone",
            "HK Phone"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView  = findViewById(R.id.textView);
        gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            txtView.setText(values[position]);
        });

    }
}