package co.edu.uniquindio.proyectofinal.model;

import java.util.ArrayList;

public class Usuario extends Persona {

    private int reserva;

    ArrayList<Reserva> listaReservas=new ArrayList<>();
    public Usuario(){

    }

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }
}
