package com.example.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
    private Button btnAgregar;

    private Button btnOpenSpinner;


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

        // 1. Vincular componentes del layout
        listDepartamentos = findViewById(R.id.lvLista);
        etNombreDepa = findViewById(R.id.etNombreDepa);
        etCodigo = findViewById(R.id.etCodigo);
        btnAgregar = findViewById(R.id.btnAgregar);

        // 2. Inicializar la lista de datos
        listDepartamentosData = new ArrayList<>();
        listDepartamentosData.add(new Departamento("Antioquia", "05"));
        listDepartamentosData.add(new Departamento("Atlántico", "08"));

        // 3. Inicializar el ArrayAdapter
        data = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listDepartamentosData);

        // 4. Asignar el adaptador al ListView
        listDepartamentos.setAdapter(data);

        // 5. Configurar el evento Click del botón
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarDepartamento();
            }
        });

        btnOpenSpinner = findViewById(R.id.btnSpinner);

        //esta vez el evento click se lo asignare desde el xml



    }

    private void agregarDepartamento() {
        String nombre = etNombreDepa.getText().toString().trim();
        String codigo = etCodigo.getText().toString().trim();

        if (!nombre.isEmpty() && !codigo.isEmpty()) {
            // Crear el nuevo objeto
            Departamento nuevoDepa = new Departamento(nombre, codigo);

            // Agregar a la lista de datos
            listDepartamentosData.add(nuevoDepa);

            // Notificar al adaptador que los datos cambiaron para refrescar la UI
            data.notifyDataSetChanged();

            // Limpiar los campos de texto
            etNombreDepa.setText("");
            etCodigo.setText("");
            etNombreDepa.requestFocus();
        } else {
            Toast.makeText(this, "Por favor completa ambos campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void goTo2ndView(View view){
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }
}
