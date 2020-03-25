package com.example.listacontactos;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    String nombre;
    String telefono;
    String grupo;


    public Usuario() {
    }

    public Usuario(String nombre, String telefono, String grupo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.grupo = grupo;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public static Creator<Usuario> getCREATOR() {
        return CREATOR;
    }

    protected Usuario(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        grupo = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(grupo);
    }
}
