package com.example.calculadorasimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText tv1, tv2;
    Button btnSomar, btnSub, btnMulti, btnDividir;

    public void imprimirDialogo(String Titulo, String mens, String botao) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle(Titulo);
        dialogo.setMessage(mens);
        dialogo.setNeutralButton(botao, null);
        dialogo.show();
    }

    public String calcular(int op, double v1, double v2) {
        String res = null;
        if (op == 1) {
            res = "O resultado da Soma é: " + (v1 + v2);
        } else if (op == 2) {
            res = "O resultado da Subtração é: " + (v1 - v2);
        } else if (op == 3) {
            res = "O resultado da Multiplicação é: " + (v1 * v2);
        } else {
            try {
                res = "O resultado da Divisão" + (v1 / v2);
            } catch (ArithmeticException ex) {
                imprimirDialogo("ERRO", "Um número não pode ser dividido por zero", "Fechar");
            }
        }
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSomar = findViewById(R.id.btnSomar);
        btnSub = findViewById(R.id.btnSubtrair);
        btnMulti = findViewById(R.id.btnMulti);
        btnDividir = findViewById(R.id.btnDividir);
        tv1 = findViewById(R.id.edtV1);
        tv2 = findViewById(R.id.edtV2);

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a, b;
                a = Double.parseDouble(tv1.getText().toString());
                b = Double.parseDouble(tv2.getText().toString());
                imprimirDialogo("Resultado Soma: ", calcular(1, a, b), "fechar");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a, b;
                a = Double.parseDouble(tv1.getText().toString());
                b = Double.parseDouble(tv2.getText().toString());
                imprimirDialogo("Resultado Subtração: ", calcular(2, a, b), "fechar");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a, b;
                a = Double.parseDouble(tv1.getText().toString());
                b = Double.parseDouble(tv2.getText().toString());
                imprimirDialogo("Resultado Multiplicação: ", calcular(3, a, b), "fechar");
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a, b;
                a = Double.parseDouble(tv1.getText().toString());
                b = Double.parseDouble(tv2.getText().toString());
                imprimirDialogo("Resultado Divisão: ", calcular(4, a, b), "fechar");
            }
        });
    }
}