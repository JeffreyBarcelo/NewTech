package com.example.listacontactos;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaContactos extends AppCompatActivity {
    private ListView Lista;
    Adapter mAdapter;
    String nombre;
    TextView txt_nombre;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);

        nombre = getIntent().getStringExtra("nombre");

        usuario = getIntent().getParcelableExtra("usuario");

        final ArrayList<Usuario> listUsuario = getIntent().getParcelableArrayListExtra("lista");
        TextView ordenar = findViewById(R.id.ordenar);
        TextView grupo = findViewById(R.id.grupo);
        TextView eliminar = findViewById(R.id.eliminar);
        TextView invertir = findViewById(R.id.invertir);


        Lista = findViewById(R.id.contacto);






        mAdapter = new Adapter(ListaContactos.this,R.layout.list_items,listUsuario);
        Lista.setAdapter(mAdapter);
        registerForContextMenu(Lista);
        ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listUsuario, new Comparator<Usuario>() {
                    @Override
                    public int compare(Usuario o1, Usuario o2) {
                        return o1.getNombre().compareTo(o2.getNombre());
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        });

        grupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listUsuario, new Comparator<Usuario>() {
                    @Override
                    public int compare(Usuario o1, Usuario o2) {
                        return o1.getGrupo().compareTo(o2.getGrupo());
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        });

        invertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.reverse(listUsuario);

                mAdapter.notifyDataSetChanged();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listUsuario.clear();
                mAdapter.notifyDataSetChanged();

            }
        });



    }




}
