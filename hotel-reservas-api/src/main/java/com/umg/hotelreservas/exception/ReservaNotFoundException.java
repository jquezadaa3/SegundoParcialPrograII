package com.umg.hotelreservas.exception;

public class ReservaNotFoundException extends RuntimeException {
    public ReservaNotFoundException(Long id) {
        super("No existe una reserva con id " + id);
    }
}
