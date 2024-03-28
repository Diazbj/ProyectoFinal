package co.edu.uniquindio.proyectofinal.model;

import java.util.ArrayList;

public class Evento {
    private String Codigo;
    private String nombre;
    private String descripcion;
    private String fecha;
    private int capacidadMax;
    ArrayList<Empleado> EmpleadosAsociados = new ArrayList<Empleado>();
    ArrayList<Reserva> ReservasAsociadas = new ArrayList<Reserva>();

    //constructor
    public Evento() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public ArrayList<Empleado> getEmpleadosAsociados() {
        return EmpleadosAsociados;
    }

    public void setEmpleadosAsociados(ArrayList<Empleado> empleadosAsociados) {
        EmpleadosAsociados = empleadosAsociados;
    }

    public ArrayList<Reserva> getReservasAsociadas() {
        return ReservasAsociadas;
    }

    public void setReservasAsociadas(ArrayList<Reserva> reservasAsociadas) {
        ReservasAsociadas = reservasAsociadas;
    }
}
