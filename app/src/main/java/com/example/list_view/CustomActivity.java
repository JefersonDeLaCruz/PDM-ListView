package com.example.list_view;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_view.Models.Producto;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvpr = findViewById(R.id.lvPr);

        lista = new ArrayList<>();

        lista.add(new Producto("champu", 45.5, R.drawable.product));
        lista.add(new Producto("bota pupu", 4445.5, R.drawable.product));
        lista.add(new Producto("labubu", 4.5, R.drawable.product));
        adapter = new AdapterProducto(lista, this);

        lvpr.setAdapter(adapter);
    }


    private ListView lvpr;

    private AdapterProducto adapter;

    private ArrayList<Producto> lista;

}