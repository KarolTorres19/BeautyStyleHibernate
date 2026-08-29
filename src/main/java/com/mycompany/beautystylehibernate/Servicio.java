package com.mycompany.beautystylehibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa un servicio ofrecido
 * por Beauty Style.
 */
@Entity
@Table(name = "servicios")
public class Servicio {

    // Identificador único del servicio.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio;

    // Datos del servicio.
    private String nombre_servicio;
    private String descripcion;
    private Double precio;

    /**
     * Constructor vacío requerido por Hibernate.
     */
    public Servicio() {
    }

    // Obtiene el identificador del servicio.
    public Integer getId_servicio() {
        return id_servicio;
    }

    // Asigna el identificador del servicio.
    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    // Obtiene el nombre del servicio.
    public String getNombre_servicio() {
        return nombre_servicio;
    }

    // Asigna el nombre del servicio.
    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    // Obtiene la descripción del servicio.
    public String getDescripcion() {
        return descripcion;
    }

    // Asigna la descripción del servicio.
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Obtiene el precio del servicio.
    public Double getPrecio() {
        return precio;
    }

    // Asigna el precio del servicio.
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
