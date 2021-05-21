package com.example.criteriosranson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseRanson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_ranson);

        Intent intent = getIntent();
        String pontuacao = intent.getStringExtra(MainActivity.EXTRA_COUNT);
        String estado = intent.getStringExtra(MainActivity.EXTRA_ESTADO);
        String mortalidade = intent.getStringExtra(MainActivity.EXTRA_MORTALIDADE);
        String idade = intent.getStringExtra(MainActivity.EXTRA_IDADE);

        TextView showPontuacao = findViewById(R.id.text_pontuacao);
        TextView showEstado = findViewById(R.id.text_result);
        TextView showMortalidade = findViewById(R.id.text_mortalidade);
        TextView showIdade = findViewById(R.id.text_idade);

        showPontuacao.setText(pontuacao);
        showEstado.setText(estado);
        showMortalidade.setText(mortalidade);
        showIdade.setText(idade);

    }
}