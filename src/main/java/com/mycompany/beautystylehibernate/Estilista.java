package com.mycompany.beautystylehibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa a un estilista registrado
 * en el sistema Beauty Style.
 */
@Entity
@Table(name = "estilistas")
public class Estilista {

    // Identificador único del estilista.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estilista;

    // Datos del estilista.
    private String nombre;
    private String especialidad;
    private String telefono;

    /**
     * Constructor vacío requerido por Hibernate.
     */
    public Estilista() {
    }

    // Obtiene el identificador del estilista.
    public Integer getId_estilista() {
        return id_estilista;
    }

    // Asigna el identificador del estilista.
    public void setId_estilista(Integer id_estilista) {
        this.id_estilista = id_estilista;
    }

    // Obtiene el nombre del estilista.
    public String getNombre() {
        return nombre;
    }

    // Asigna el nombre del estilista.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtiene la especialidad del estilista.
    public String getEspecialidad() {
        return especialidad;
    }

    // Asigna la especialidad del estilista.
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Obtiene el teléfono del estilista.
    public String getTelefono() {
        return telefono;
    }

    // Asigna el teléfono del estilista.
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
