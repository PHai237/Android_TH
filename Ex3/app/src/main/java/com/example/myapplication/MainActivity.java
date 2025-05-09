package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edtA);
        edt2 = findViewById(R.id.edtB);
        edt3 = findViewById(R.id.edtResult);
        btncong = findViewById(R.id.btnTotal);
        btntru = findViewById(R.id.btnSubtraction);
        btnnhan = findViewById(R.id.btnMultiplication);
        btnchia = findViewById(R.id.btnDivision);

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                edt3.setText("A + B = " + (a + b));
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                edt3.setText("A - B = " + (a - b));
            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                edt3.setText("A * B = " + (a * b));
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());

                if (b == 0) {
                    edt3.setText("Không thể chia cho 0");
                } else {
                    float kq = (float) a / b;
                    edt3.setText("A / B = " + kq);
                }
            }
        });
    }
}