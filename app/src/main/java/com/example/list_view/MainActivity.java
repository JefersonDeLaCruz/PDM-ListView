package com.example.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_view.Models.Departamento;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Departamento> listDepartamentosData;
    private ListView listDepartamentos;
    private ArrayAdapter<Departamento> data;

    private EditText etNombreDepa, etCodigo;
    private Button btnAgregar, btnVista, btnCustomPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listDepartamentos = findViewById(R.id.lvLista);
        etNombreDepa = findViewById(R.id.etNombreDepa);
        etCodigo = findViewById(R.id.etCodigo);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnVista = findViewById(R.id.btnVista);
        btnCustomPractice = findViewById(R.id.btnCustomPractice);

        listDepartamentosData = new ArrayList<>();
        listDepartamentosData.add(new Departamento("Antioquia", "05"));
        listDepartamentosData.add(new Departamento("Atlántico", "08"));

        data = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listDepartamentosData);
        listDepartamentos.setAdapter(data);

        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intent);
        });

//        btnVista.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//            startActivity(intent);
//        });

        btnCustomPractice.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CustomActivity.class);
            startActivity(intent);
        });
    }
}
