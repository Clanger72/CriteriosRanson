package com.example.criteriosranson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ESTADO = "com.example.criteriosranson.extra.ESTADO";
    public static final String EXTRA_COUNT = "com.example.criteriosranson.extra.COUNT";
    public static final String EXTRA_MORTALIDADE = "com.example.criteriosranson.extra.MORTALIDADE";
    public static final String EXTRA_IDADE = "com.example.criteriosranson.extra.IDADE";

    private EditText iIdadeEditText;
    private EditText nNomeEditText;
    private CheckBox cChackBox;
    private EditText lLeococitosEditText;
    private EditText gGlicemiaEditText;
    private EditText aAstTgoEditText;
    private EditText lLdhEditText;

    private int count = 0;
    private String estado_paciente;
    private String mortalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nNomeEditText = findViewById(R.id.editText_name);
        iIdadeEditText = findViewById(R.id.editText_idade);
        cChackBox = findViewById(R.id.checkBox_litiase);
        lLeococitosEditText = findViewById(R.id.editText_leococitos);
        gGlicemiaEditText = findViewById(R.id.editText_glicemia);
        aAstTgoEditText = findViewById(R.id.editText_ast_tgo);
        lLdhEditText = findViewById(R.id.editText_ldh);

    }

    public void calculateRanson(View view) {
        int idade = 55;
        int leococitos = 16000;
        double glicemia = 11;
        int astTgo = 250;
        int ldh = 350;
        if(cChackBox.isChecked()) {
            idade = 70;
            leococitos = 18000;
            glicemia = 12.2;
            ldh = 400;
        }
        if(Integer.parseInt(iIdadeEditText.getText().toString()) > idade){
            count ++;
        }
        if(Integer.parseInt(lLeococitosEditText.getText().toString()) > leococitos){
            count ++;
        }
        if(Integer.parseInt(gGlicemiaEditText.getText().toString()) > glicemia){
            count ++;
        }
        if(Integer.parseInt(aAstTgoEditText.getText().toString()) > astTgo){
            count ++;
        }
        if(Integer.parseInt(lLdhEditText.getText().toString()) > ldh){
            count ++;
        }
        if(count >= 3){
            estado_paciente = "Pancreatite não é grave";
        }
        if(count < 3){
            estado_paciente = "Pancreatite grave";
            mortalidade = "2%";
        }
        if(count >= 3 & count <= 4){
            mortalidade = "15%";
        }
        if(count >= 5 & count <= 6){
            mortalidade = "40%";
        }

        Intent intent = new Intent(this, ResponseRanson.class);
        intent.putExtra(EXTRA_ESTADO, estado_paciente);
        intent.putExtra(EXTRA_COUNT, Integer.toString(count));
        intent.putExtra(EXTRA_MORTALIDADE, mortalidade);
        intent.putExtra(EXTRA_IDADE, iIdadeEditText.getText().toString());
        startActivity(intent);
    }
}