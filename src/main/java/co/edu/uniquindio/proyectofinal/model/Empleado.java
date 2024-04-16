package co.edu.uniquindio.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.exceptions.EmpleadoException;

import java.util.ArrayList;

public class Empleado extends Persona {


    private String evento;
    ArrayList<Evento> EventosAsignados=new ArrayList<>();


    public Empleado(){

    }

    public ArrayList<Evento> getEventosAsignados() {
        return EventosAsignados;
    }

    public void setEventosAsignados(ArrayList<Evento> eventosAsignados) {
        EventosAsignados = eventosAsignados;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public void datosListaEventosAsig(String evento) throws EmpleadoException {
        try {
            // Validación de datos
            if (evento != null && !evento.isEmpty()) {
                this.evento = evento;
            } else {
                throw new NullPointerException("La lista de eventos asignados es nula o vacía.");
            }
        } catch (NullPointerException e) {
            throw new EmpleadoException("Error: " + e.getMessage());
        }
    }
}
