package co.edu.uniquindio.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.controller.service.IEventoControllerService;
import co.edu.uniquindio.proyectofinal.mapping.dto.EventoDto;

import java.util.List;

public class EventoController implements IEventoControllerService {

    ModelFactoryController modelFactoryController;
    public EventoController(){ modelFactoryController = ModelFactoryController.getInstance();}

    @Override
    public List<EventoDto> obtenerEventos() {
        return modelFactoryController.obtenerEventos();
    }

    @Override
    public boolean agregarEvento(EventoDto eventoDto) {
        return modelFactoryController.agregarEvento(eventoDto);
    }

    @Override
    public boolean eliminarEvento(String id) {
        return modelFactoryController.eliminarEventos(id);
    }

    @Override
    public boolean actualizarEvento(String idActual, EventoDto eventoDto) {
        return modelFactoryController.actualizarEventos(idActual,eventoDto);
    }
}