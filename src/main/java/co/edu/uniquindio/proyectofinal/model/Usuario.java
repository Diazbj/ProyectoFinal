package co.edu.uniquindio.proyectofinal.model;

import java.util.ArrayList;

public class Usuario extends Persona {

    ArrayList<Reserva> listaReservasAsociado = new ArrayList<>();

    ArrayList<Reserva> listaReservas=new ArrayList<>();
    public Usuario(){

    }

    public ArrayList<Reserva> getListaReservasAsociado() {
        return listaReservasAsociado;
    }

    public void setListaReservasAsociado(ArrayList<Reserva> listaReservasAsociado) {
        this.listaReservasAsociado = listaReservasAsociado;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }
}
