package com.example.list_view.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

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

//        RecyclerView.ViewHolder holder;


        return null;
    }

    static class ViewHolder{

        public ImageView imagen;
        public TextView txtNombre;
        public TextView txtPrecio;
        public Button btnAddCart;
        public Button btnEliminar;
    }
}
