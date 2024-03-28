package co.edu.uniquindio.proyectofinal.model;

import java.util.ArrayList;

public class Empleado extends Persona {

    ArrayList<Evento> EventosAsignados=new ArrayList<>();

    public Empleado(){

    }

    public ArrayList<Evento> getEventosAsignados() {
        return EventosAsignados;
    }

    public void setEventosAsignados(ArrayList<Evento> eventosAsignados) {
        EventosAsignados = eventosAsignados;
    }

}
