package com.mycompany.beautystylehibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estilistas")
public class Estilista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estilista;

    private String nombre;
    private String especialidad;
    private String telefono;

    public Estilista() {
    }

    public Integer getId_estilista() {
        return id_estilista;
    }

    public void setId_estilista(Integer id_estilista) {
        this.id_estilista = id_estilista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}