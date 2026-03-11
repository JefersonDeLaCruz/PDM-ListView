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

import com.example.list_view.Models.Producto;

import java.util.ArrayList;

public class AdapterProduct extends BaseAdapter {

    public ArrayList<Producto> productos;

    public LayoutInflater inflater;

    public Context context;

    public AdapterProduct(ArrayList<Producto> productos, Context context) {
        this.productos = productos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.producto_row, parent, false);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.ivImage);
            holder.name = convertView.findViewById(R.id.tvName);
            holder.price = convertView.findViewById(R.id.tvPrice);
            holder.btnDelete = convertView.findViewById(R.id.btnDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Producto producto = productos.get(position);

        holder.image.setImageResource(producto.getImagen());
        holder.name.setText(producto.getNombre());
        holder.price.setText(String.valueOf(producto.getPrecio()));

        holder.btnDelete.setOnClickListener(v -> {
            productos.remove(position);
            notifyDataSetChanged();
            Toast.makeText(context, "Eliminado: " + producto.getNombre(), Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }

    static class ViewHolder {
        public ImageView image;
        public TextView name, price;
        public Button btnDelete;
    }
}
