package com.example.gregoriantolunarcalendarconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnTieptuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        btnTieptuc = findViewById(R.id.button);
        btnGiai = findViewById(R.id.button2);
        btnThoat = findViewById(R.id.button3);
        edita = findViewById(R.id.editTextText);
        editb = findViewById(R.id.editTextText2);
        editc = findViewById(R.id.editTextText3);
        txtkq = findViewById(R.id.textView5);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                if (sa.isEmpty() || sb.isEmpty() || sc.isEmpty()) {
                    txtkq.setText("Vui lòng nhập đầy đủ a, b, c");
                    return;
                }

                try {
                    int a = Integer.parseInt(sa);
                    int b = Integer.parseInt(sb);
                    int c = Integer.parseInt(sc);
                    String kq;
                    DecimalFormat dcf = new DecimalFormat("0.00");

                    if (a == 0) {
                        if (b == 0) {
                            if (c == 0)
                                kq = "Phương trình vô số nghiệm";
                            else
                                kq = "Phương trình vô nghiệm";
                        } else {
                            kq = "Phương trình có 1 nghiệm: x = " + dcf.format(-c / (double) b);
                        }
                    } else {
                        double delta = b * b - 4 * a * c;
                        if (delta < 0) {
                            kq = "Phương trình vô nghiệm";
                        } else if (delta == 0) {
                            kq = "Phương trình có nghiệm kép: x1 = x2 = " + dcf.format(-b / (2.0 * a));
                        } else {
                            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                            kq = "Phương trình có 2 nghiệm:\n"
                                    + "x1 = " + dcf.format(x1) + "\n"
                                    + "x2 = " + dcf.format(x2);
                        }
                    }

                    txtkq.setText(kq);

                } catch (NumberFormatException e) {
                    txtkq.setText("Giá trị nhập không hợp lệ. Hãy nhập số nguyên.");
                }
            }
        });

        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                txtkq.setText("");
                edita.requestFocus();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
