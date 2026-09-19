package com.umg.hotelreservas.service;

import com.umg.hotelreservas.exception.ReservaInvalidaException;
import com.umg.hotelreservas.exception.ReservaNotFoundException;
import com.umg.hotelreservas.model.EstadoReserva;
import com.umg.hotelreservas.model.Reserva;
import com.umg.hotelreservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva crear(Reserva reserva) {
        if (!reserva.getFechaSalida().isAfter(reserva.getFechaEntrada())) {
            throw new ReservaInvalidaException("fechaSalida debe ser posterior a fechaEntrada");
        }
        reserva.setId(null);
        reserva.setEstado(EstadoReserva.PENDIENTE);
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));
    }

    public Reserva actualizar(Long id, Reserva datos) {
        Reserva reserva = obtenerPorId(id);

        if (!datos.getFechaSalida().isAfter(datos.getFechaEntrada())) {
            throw new ReservaInvalidaException("fechaSalida debe ser posterior a fechaEntrada");
        }

        reserva.setNombreCliente(datos.getNombreCliente());
        reserva.setHabitacion(datos.getHabitacion());
        reserva.setFechaEntrada(datos.getFechaEntrada());
        reserva.setFechaSalida(datos.getFechaSalida());
        if (datos.getEstado() != null) {
            reserva.setEstado(datos.getEstado());
        }

        return reservaRepository.save(reserva);
    }

    public Reserva cancelar(Long id) {
        Reserva reserva = obtenerPorId(id);
        reserva.setEstado(EstadoReserva.CANCELADA);
        return reservaRepository.save(reserva);
    }
}
