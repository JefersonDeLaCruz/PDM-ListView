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

public class practica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practica);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvProductos = findViewById(R.id.lvProductos);


        productos = new ArrayList<>();

        productos.add(new Producto("labubu",  R.drawable.product, 7.25));
        productos.add(new Producto("al",  R.drawable.product, 7.25));
        productos.add(new Producto("lafsd",  R.drawable.product, 7.25));
        productos.add(new Producto("lmesi",  R.drawable.product, 7.25));
        productos.add(new Producto("lasdadu",  R.drawable.product, 7.25));
        productos.add(new Producto("labubu",  R.drawable.product, 7.25));
        productos.add(new Producto("lasdsadau",  R.drawable.product, 7.25));
        productos.add(new Producto("labubu",  R.drawable.product, 7.25));
        productos.add(new Producto("dsada",  R.drawable.product, 7.25));
        productos.add(new Producto("labubu",  R.drawable.product, 7.25));
        productos.add(new Producto("labubu",  R.drawable.product, 7.25));
        productos.add(new Producto("dsadau",  R.drawable.product, 7.25));
        productos.add(new Producto("labubu",  R.drawable.product, 7.25));

        adapter = new AdapterProduct(productos,  this);

        lvProductos.setAdapter(adapter);

    }

    private ArrayList<Producto> productos;

    private AdapterProduct adapter;

    private ListView lvProductos;
















}