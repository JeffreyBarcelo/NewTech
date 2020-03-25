package com.example.listacontactos;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText nombre_contacto, telefono_contacto;
    Spinner spinner;
    Button guardar;
    String nombre,telefono, grupo;
    Usuario mi_usuario;
    String gp;
    ArrayList<Usuario> usuarioList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre_contacto = (EditText)findViewById(R.id.nombre);
        telefono_contacto = (EditText)findViewById(R.id.telefono);
        spinner =(Spinner)findViewById(R.id.spinner);
        guardar = (Button)findViewById(R.id.guardar);

        usuarioList = new ArrayList<>();

        registerForContextMenu(telefono_contacto);
        registerForContextMenu(nombre_contacto);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = nombre_contacto.getText().toString();
                telefono = telefono_contacto.getText().toString();
                grupo = spinner.getSelectedItem().toString();

                if (nombre.isEmpty() || telefono.isEmpty() ){
                    Toast.makeText(MainActivity.this, "te falta validad un campo", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                    mi_usuario = new Usuario();
                    mi_usuario.setNombre(nombre);
                    mi_usuario.setGrupo(grupo);
                    mi_usuario.setTelefono(telefono);
                    usuarioList.add(mi_usuario);

                }
            }
        });

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Escoge una opcion");

        getMenuInflater().inflate(R.menu.telefonos,menu);
        getMenuInflater().inflate(R.menu.contextual_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
        if (id== R.id.opcion){
            Random rnd = new Random();
            int array[] = new int[30];
            for(int i = 0; i < array.length; i++)
                telefono_contacto.setText("300"+rnd.nextInt(9000000-(-30)+5));

       }
        else if (id==R.id.opcion2){
            Random rnd = new Random();
            int array[] = new int[30];
            for(int i = 0; i < array.length; i++)
                telefono_contacto.setText("310"+rnd.nextInt(9000000-(-30)+5));
        }
        else if (id==R.id.opcion3){
            Random rnd = new Random();
            int array[] = new int[30];
            for(int i = 0; i < array.length; i++)
                telefono_contacto.setText("320"+rnd.nextInt(9000000-(-30)+5));

        }
        else if(id==R.id.convertir){
            String edt = nombre_contacto.getText().toString();
            if (edt.equals(edt.toLowerCase()))
                nombre_contacto.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        }
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.limpiar_campos){
            nombre_contacto.setText("");
            telefono_contacto.setText("");
        }
        else if(id == R.id.ver_contactos){
            Intent intent = new Intent(MainActivity.this, ListaContactos.class);
            intent.putExtra("nombre",nombre);
            intent.putExtra("usuario",mi_usuario);
            intent.putExtra("lista",usuarioList);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        gp =(String)spinner.toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}