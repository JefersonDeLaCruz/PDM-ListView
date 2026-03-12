package com.example.list_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_view.Models.Departamento;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    // Hacemos la lista y el adaptador estáticos para poder acceder desde el otro Activity/Adapter
    public static ArrayList<Departamento> dps = new ArrayList<>();
    public static ArrayAdapter<Departamento> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvData = findViewById(R.id.lvData);

        // Solo inicializamos si la lista está vacía (para no perder lo que agregamos desde el carrito)
        if (dps.isEmpty()) {
            dps.add(new Departamento("messi", "67"));
            dps.add(new Departamento("hola", "67"));
            dps.add(new Departamento("que tal", "67"));
            dps.add(new Departamento("mundo", "67"));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dps);
        lvData.setAdapter(adapter);

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Departamento dp = (Departamento) parent.getItemAtPosition(position);
                Toast.makeText(SpinnerActivity.this,
                        String.format("Departamento: %s\nCodigo del depa mi pa: %s", dp.getNombreDepa(), dp.getCodigo()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ListView lvData;
}
