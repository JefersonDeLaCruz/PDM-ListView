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



    private Button btnSpinner;

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

        // TODO: IMPLEMENTAR ELIMINACIÓN POR LONG CLICK AQUÍ


        // 5. Configurar el evento Click del botón
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarDepartamento();
            }
        });

        // TODO: IMPLEMENTAR VALIDACIÓN EN TIEMPO REAL (TEXTWATCHER) AQUÍ


        btnSpinner = findViewById(R.id.btnSpinner);

        btnSpinner.setOnClickListener(v -> {

            openSpinnerActivity();

        });
    }

    private void agregarDepartamento() {
        String nombre = etNombreDepa.getText().toString().trim();
        String codigo = etCodigo.getText().toString().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || codigo.isEmpty()) {
            Toast.makeText(this, "Por favor completa ambos campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: IMPLEMENTAR VALIDACIÓN DE PATRON XXXX-XXXX AQUÍ

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
        Toast.makeText(this, "Departamento agregado con éxito", Toast.LENGTH_SHORT).show();
    }

    private void openSpinnerActivity(){
        Intent intent = new Intent(this, spinnerActivity.class);

        startActivity(intent);
    }
}
