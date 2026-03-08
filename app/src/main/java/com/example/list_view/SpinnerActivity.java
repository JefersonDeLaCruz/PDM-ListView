package com.example.list_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_view.Models.Departamento;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {


    //lista que almacenara los datos (objetos)

    private ArrayList<Departamento> dps;

    //spinner
    private Spinner sp;




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



        sp = findViewById(R.id.spDepa);
        //inicializamos lista y le metemos algo de data me entendes va
        dps = new ArrayList<>();

        dps.add(new Departamento("messi", "121"));
        dps.add(new Departamento("avla", "121"));
        dps.add(new Departamento("ojpa", "121"));

        //INCIALIZAR EL ARRAY ADAPATER

        ArrayAdapter<Departamento> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dps);

        //ahora que ya tenemos la data y el contexto listo solo necesitamos montar el adapter al spinner

        //este metodo hasta donde he probado es opcional o necesario del todo ya que esto se esta definiendo en el 2nd param del adapter
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                Object obj = parent.getItemAtPosition(position);

                Departamento dp = dps.get(position);


                Toast.makeText(SpinnerActivity.this,
                        String.format("Departamento: %s\nCodigo: %s", dp.getNombreDepa() , dp.getCodigo()),
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}