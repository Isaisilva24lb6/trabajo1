package com.example.trabajo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtnumerosig;
    private Button button;
    private TextView txtLista;
    private List<Integer> numerosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnumerosig = findViewById(R.id.txtnumerosig);
        button = findViewById(R.id.button);
        txtLista = findViewById(R.id.txtLista);

        numerosList = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero();
            }
        });
    }

    private void agregarNumero() {
        String numeroIngresadoStr = txtnumerosig.getText().toString();

        if (!numeroIngresadoStr.isEmpty()) {
            int numeroIngresado = Integer.parseInt(numeroIngresadoStr);
            numerosList.add(numeroIngresado);

            actualizarLista();
        }
    }

    private void actualizarLista() {
        StringBuilder listaTexto = new StringBuilder();

        for (int numero : numerosList) {
            listaTexto.append(numero).append(", ");
        }

        // Elimina la coma y el espacio extra al final
        if (listaTexto.length() > 1) {
            listaTexto.deleteCharAt(listaTexto.length() - 1);
            listaTexto.deleteCharAt(listaTexto.length() - 1);
        }

        txtLista.setText(listaTexto.toString());
        txtnumerosig.setText(""); // Limpia el EditText después de agregar el número
    }
}