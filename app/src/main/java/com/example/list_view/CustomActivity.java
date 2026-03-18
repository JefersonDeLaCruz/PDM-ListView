package com.example.list_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_view.Models.Producto;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {

    private EditText etNombreProducto;
    private EditText etPrecioProducto;

    private Button btnAgregarProducto;

    private ListView lvProductos;

    private ProductoAdapter adapter;
    private ArrayList<Producto> listaProductos;



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

        inicializarViews();
        setupData();
        setupListeners();
    }

    public void inicializarViews(){

        etNombreProducto = findViewById(R.id.etNombreProducto);
        etPrecioProducto = findViewById(R.id.etPrecioProducto);

        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);

        lvProductos = findViewById(R.id.lvProductosCustom);

    }

    public void setupData(){

        listaProductos = new ArrayList<>();

        listaProductos.add(new Producto(R.drawable.product, "Sunblock", "bloquea el sol", 12.5));

        adapter = new ProductoAdapter(this, listaProductos);

        lvProductos.setAdapter(adapter);

    }

    public void setupListeners(){
        btnAgregarProducto.setOnClickListener( v -> {
            agregarProducto();
        });

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDescription(listaProductos.get(position));
            }
        });
    }

    private void agregarProducto(){

        String nombre = etNombreProducto.getText().toString();
        String precio = etPrecioProducto.getText().toString();
        int image = R.drawable.product;

        if(nombre.isBlank() && precio.isBlank()){

            Toast.makeText(this, "brother llena los campos", Toast.LENGTH_SHORT).show();

        }else{

            Producto pr = new Producto(image, nombre, Double.parseDouble(precio));
            listaProductos.add(pr);

            adapter.notifyDataSetChanged();

        }




    }

    private void showDescription(Producto producto){
        String descripcion = "Sin descripcion";
        if(!(producto.getDescripcion() == null)){
            Toast.makeText(this, "Descripcion: " + producto.getDescripcion(), Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Descripcion: " + descripcion, Toast.LENGTH_SHORT).show();

    }
}