package com.mycompany.beautystylehibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entidad que representa una cita en el sistema Beauty Style.
 * Se encuentra relacionada con un cliente, un estilista y un servicio.
 */
@Entity
@Table(name = "citas")
public class Cita {

    // Identificador único de la cita.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cita;

    // Fecha programada para la cita.
    private LocalDate fecha;

    // Hora programada para la cita.
    private LocalTime hora;

    // Estado actual de la cita.
    private String estado;

    // Cliente que realizó la reserva.
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Estilista asignado a la cita.
    @ManyToOne
    @JoinColumn(name = "id_estilista")
    private Estilista estilista;

    // Servicio seleccionado para la cita.
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    /**
     * Constructor vacío requerido por Hibernate.
     */
    public Cita() {
    }

    // Obtiene el identificador de la cita.
    public Integer getId_cita() {
        return id_cita;
    }

    // Asigna el identificador de la cita.
    public void setId_cita(Integer id_cita) {
        this.id_cita = id_cita;
    }

    // Obtiene la fecha de la cita.
    public LocalDate getFecha() {
        return fecha;
    }

    // Asigna la fecha de la cita.
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Obtiene la hora de la cita.
    public LocalTime getHora() {
        return hora;
    }

    // Asigna la hora de la cita.
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    // Obtiene el estado de la cita.
    public String getEstado() {
        return estado;
    }

    // Asigna el estado de la cita.
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Obtiene el cliente asociado a la cita.
    public Cliente getCliente() {
        return cliente;
    }

    // Asocia un cliente con la cita.
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Obtiene el estilista asociado a la cita.
    public Estilista getEstilista() {
        return estilista;
    }

    // Asocia un estilista con la cita.
    public void setEstilista(Estilista estilista) {
        this.estilista = estilista;
    }

    // Obtiene el servicio asociado a la cita.
    public Servicio getServicio() {
        return servicio;
    }

    // Asocia un servicio con la cita.
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
