package com.mycompany.beautystylehibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa a un cliente registrado
 * en el sistema Beauty Style.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    // Identificador único del cliente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    // Datos personales y de acceso del cliente.
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String usuario;
    private String contrasena;

    /**
     * Constructor vacío requerido por Hibernate.
     */
    public Cliente() {
    }

    // Obtiene el identificador del cliente.
    public Integer getId_cliente() {
        return id_cliente;
    }

    // Asigna el identificador del cliente.
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    // Obtiene el nombre del cliente.
    public String getNombre() {
        return nombre;
    }

    // Asigna el nombre del cliente.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtiene el apellido del cliente.
    public String getApellido() {
        return apellido;
    }

    // Asigna el apellido del cliente.
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Obtiene el teléfono del cliente.
    public String getTelefono() {
        return telefono;
    }

    // Asigna el teléfono del cliente.
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Obtiene el correo electrónico del cliente.
    public String getCorreo() {
        return correo;
    }

    // Asigna el correo electrónico del cliente.
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Obtiene el nombre de usuario.
    public String getUsuario() {
        return usuario;
    }

    // Asigna el nombre de usuario.
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Obtiene la contraseña del cliente.
    public String getContrasena() {
        return contrasena;
    }

    // Asigna la contraseña del cliente.
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
