package com.example.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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

        // --- ELIMINAR SIN CUSTOM ADAPTER (USANDO LONG CLICK) ---
        listDepartamentos.setOnItemLongClickListener((parent, view, position, id) -> {
            Departamento seleccionado = listDepartamentosData.get(position);

            new AlertDialog.Builder(this)
                    .setTitle("Eliminar registro")
                    .setMessage("¿Deseas eliminar a " + seleccionado.getNombreDepa() + "?")
                    .setPositiveButton("Eliminar", (dialog, which) -> {
                        listDepartamentosData.remove(position);
                        data.notifyDataSetChanged();
                        Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();

            return true; // Importante: retorna true para que no se dispare el onClick normal
        });

        // 5. Configurar el evento Click del botón
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarDepartamento();
            }
        });

        // --- NUEVA VALIDACIÓN EN TIEMPO REAL ---
        
        // Limitamos a 9 caracteres (xxxx-xxxx)
        etCodigo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(9) });

        etCodigo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String currentText = s.toString();
                String regex = "^[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}$";
                
                if (currentText.matches(regex)) {
                    // Si el patrón está completo y es válido
                    etCodigo.setError(null);
                    Toast.makeText(MainActivity.this, "¡Código completo!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

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

        // Validación final
        String regex = "^[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}$";

        if (codigo.matches(regex)) {
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
        } else {
            Toast.makeText(this, "El código debe tener el formato xxxx-xxxx", Toast.LENGTH_LONG).show();
            etCodigo.setError("Formato inválido");
        }
    }

    private void openSpinnerActivity(){
        Intent intent = new Intent(this, spinnerActivity.class);

        startActivity(intent);
    }
}
