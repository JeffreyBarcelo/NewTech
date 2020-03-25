package com.example.listacontactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Usuario>  {

    private ArrayList<Usuario> usuariosList;
    private Context context;
    private int resourceLayout;

    public Adapter(Context context, int resource, ArrayList<Usuario> usuariosList) {
        super(context, resource, usuariosList);
        this.usuariosList = usuariosList;
        this.context = context;
        this.resourceLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        String nombre = getItem(position).getNombre();
        String telefono = getItem(position).getTelefono();
        String grupo = getItem(position).getGrupo();
        if (view == null)
            view = LayoutInflater.from(context).inflate(resourceLayout,null);


        TextView txt_nombre = view.findViewById(R.id.nombre_contacto);
        TextView txt_telefono = view.findViewById(R.id.telefono_contacto);
        TextView txt_grupo = view.findViewById(R.id.grupo_contacto);



        txt_nombre.setText(nombre);
        txt_telefono.setText(telefono);
        txt_grupo.setText(grupo);


        return view;
    }



}
