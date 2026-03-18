package com.example.list_view;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.list_view.Models.Producto;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductoAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Producto> listaProductos;

    private LayoutInflater inflater;

    public ProductoAdapter(Context context, ArrayList<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){

            convertView = inflater.inflate(R.layout.custom_producto, parent, false);

            holder = new ViewHolder();

            holder.nombre = convertView.findViewById(R.id.tvCustomNombre);
            holder.precio = convertView.findViewById(R.id.tvCustomPrecio);

            holder.imagen = convertView.findViewById(R.id.ivCustomImagen);
            holder.btnBorrar = convertView.findViewById(R.id.btnCustomBorrar);

            convertView.setTag(holder);



        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        Producto producto = listaProductos.get(position);

        holder.nombre.setText(producto.getNombreProducto());
        holder.precio.setText(String.valueOf(producto.getPrecio()));

        holder.imagen.setImageResource(producto.getImagen());

        return convertView;




    }


    static class ViewHolder{
        //esta clase es un mirror del custom layout (el que representa la fila)

        private ImageView imagen;
        private TextView nombre;
        private TextView precio;
        private ImageButton btnBorrar;
    }
}
