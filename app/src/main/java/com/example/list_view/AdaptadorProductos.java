package com.example.list_view;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.list_view.Models.Producto;

import java.util.ArrayList;

public class AdaptadorProductos extends BaseAdapter {

    public ArrayList<Producto> listaProductos;

    public Context context;

    public LayoutInflater inflater;

    public AdaptadorProductos(ArrayList<Producto> listaProductos, Context context) {
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

        if(convertView == null ){

            convertView = inflater.inflate(R.layout.item_productos, parent, false);
            holder = new ViewHolder();
            holder.nombreProducto = convertView.findViewById(R.id.tvNombre);
            holder.precioProducto = convertView.findViewById(R.id.tvPrecio);
            holder.image = convertView.findViewById(R.id.ivImagen);
            holder.btnEliminar = convertView.findViewById(R.id.btnEliminar);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Producto producto = listaProductos.get(position);

        holder.nombreProducto.setText(producto.getNombreProducto());
        holder.precioProducto.setText(String.valueOf(producto.getPrecio()));
        holder.image.setImageResource(producto.getImagen());
        
        return convertView;
        //return null;
    }

    static class ViewHolder{
        public TextView nombreProducto, precioProducto;
        public ImageView image;

        public Button btnEliminar;


    }
}
