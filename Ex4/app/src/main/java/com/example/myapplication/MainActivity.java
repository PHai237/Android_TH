package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
    EditText edtdoC, edtdoF;
    Button btncf, btnfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtdoC = findViewById(R.id.edtdoC);
        edtdoF = findViewById(R.id.edtdoF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doc = edtdoC.getText().toString();
                try {
                    int C = Integer.parseInt(doc);
                    edtdoF.setText("" + dcf.format(C * 1.8 + 32));
                } catch (NumberFormatException e) {
                    edtdoF.setText("Invalid input");
                }
            }
        });

        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String dof = edtdoF.getText().toString();
                try {
                    int F = Integer.parseInt(dof);
                    edtdoC.setText("" + dcf.format((F - 32) / 1.8));
                } catch (NumberFormatException e) {
                    edtdoC.setText("Invalid input");
                }
            }
        });
    }
}
