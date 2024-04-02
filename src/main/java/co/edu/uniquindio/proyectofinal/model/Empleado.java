package co.edu.uniquindio.proyectofinal.model;

import java.util.ArrayList;

public class Empleado extends Persona {

    ArrayList<Evento> EventosAsignados=new ArrayList<>();
    private String evento;

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
}
