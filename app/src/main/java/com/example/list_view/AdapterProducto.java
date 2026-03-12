package com.example.list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.list_view.Models.Departamento;
import com.example.list_view.Models.Producto;

import java.util.ArrayList;

public class AdapterProducto extends BaseAdapter {

    public ArrayList<Producto> listaProductos;

    public Context context;

    public LayoutInflater inflater;
    public AdapterProducto(ArrayList<Producto> listaProductos, Context context) {
        this.listaProductos = listaProductos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null  ) {

        convertView = inflater.inflate(R.layout.custom_producto, parent, false);
        holder = new ViewHolder();

        holder.imagen = convertView.findViewById(R.id.imgProducto);
        holder.txtNombre = convertView.findViewById(R.id.txtNombre);
        holder.txtPrecio = convertView.findViewById(R.id.txtPrecio);
        holder.btnEliminar = convertView.findViewById(R.id.btnEliminar);
        holder.btnAddCart = convertView.findViewById(R.id.btnAddCart);

        convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        Producto pr = listaProductos.get(position);

        holder.txtNombre.setText(pr.getNombre());
        holder.txtPrecio.setText(String.valueOf(pr.getPrecio()));
        holder.imagen.setImageResource(pr.getImagen());

        holder.btnEliminar.setOnClickListener(v -> {
            listaProductos.remove(position);
            notifyDataSetChanged();
            Toast.makeText(context, "Eliminado: " + pr.getNombre(), Toast.LENGTH_SHORT).show();
        });

        holder.btnAddCart.setOnClickListener(v -> {
            // Creamos el nuevo departamento basado en el producto
            Departamento nuevoDepa = new Departamento(pr.getNombre(), String.valueOf(pr.getPrecio()));
            
            // Lo agregamos a la lista estática de SpinnerActivity
            SpinnerActivity.dps.add(nuevoDepa);
            
            // Si el adaptador ya existe, notificamos el cambio
            if (SpinnerActivity.adapter != null) {
                SpinnerActivity.adapter.notifyDataSetChanged();
            }

            Toast.makeText(context, "Producto enviado a la lista de departamentos!", Toast.LENGTH_SHORT).show();
            
            // Animacion feedback
            v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
            }).start();
        });

        return convertView;
    }

    static class ViewHolder{

        public ImageView imagen;
        public TextView txtNombre;
        public TextView txtPrecio;
        public Button btnAddCart;
        public Button btnEliminar;
    }
}
