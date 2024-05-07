package co.edu.uniquindio.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.mapping.dto.EventoDto;

import java.util.List;

public interface IEventoControllerService {

    List<EventoDto> obtenerEventos();
    boolean agregarEvento(EventoDto eventoDto);
    boolean eliminarEvento(String id);
    boolean actualizarEvento(String idActual, EventoDto eventoDto);
}
