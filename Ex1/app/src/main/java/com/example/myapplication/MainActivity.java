package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Khai báo các biến giao diện
    EditText edtA, edtB, edtResult;
    Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Chú ý: không có khoảng trắng

        // Ánh xạ các biến giao diện với ID trong layout
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtResult = findViewById(R.id.edtResult);
        btnTotal = findViewById(R.id.btnTotal);

        // Xử lý sự kiện khi nhấn nút "Tổng"
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());
                    int c = a + b;
                    edtResult.setText(String.valueOf(c));
                } catch (NumberFormatException e) {
                    edtResult.setText("Lỗi nhập liệu");
                }
            }
        });
    }
}
