package com.umg.hotelreservas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Reserva {

    private Long id;

    @NotBlank(message = "nombreCliente es obligatorio")
    private String nombreCliente;

    @NotBlank(message = "habitacion es obligatoria")
    private String habitacion;

    @NotNull(message = "fechaEntrada es obligatoria")
    private LocalDate fechaEntrada;

    @NotNull(message = "fechaSalida es obligatoria")
    private LocalDate fechaSalida;

    private EstadoReserva estado;

    public Reserva() {
    }

    public Reserva(Long id, String nombreCliente, String habitacion, LocalDate fechaEntrada, LocalDate fechaSalida, EstadoReserva estado) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}
