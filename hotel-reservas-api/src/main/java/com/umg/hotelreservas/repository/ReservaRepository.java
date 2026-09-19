package com.umg.hotelreservas.repository;

import com.umg.hotelreservas.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();
    private long siguienteId = 1;

    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(siguienteId++);
            reservas.add(reserva);
        } else {
            for (int i = 0; i < reservas.size(); i++) {
                if (reservas.get(i).getId().equals(reserva.getId())) {
                    reservas.set(i, reserva);
                }
            }
        }
        return reserva;
    }

    public List<Reserva> findAll() {
        return reservas;
    }

    public Optional<Reserva> findById(Long id) {
        return reservas.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
