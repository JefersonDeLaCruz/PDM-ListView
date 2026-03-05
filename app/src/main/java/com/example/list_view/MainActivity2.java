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

public class MainActivity2 extends AppCompatActivity {
    public ArrayList<Producto> dataProducto;
    public AdaptadorProductos adapdator;

    public ListView listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaProductos = findViewById(R.id.listaProductos);

        dataProducto = new ArrayList<>();

        dataProducto.add(new Producto(R.drawable.pr, "sopa", 2.5));
        dataProducto.add(new Producto(R.drawable.pr2, "cocacola", 67));

        adapdator = new AdaptadorProductos(dataProducto, this);

        listaProductos.setAdapter(adapdator);



    }
}