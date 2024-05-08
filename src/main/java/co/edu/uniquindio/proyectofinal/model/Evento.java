package co.edu.uniquindio.proyectofinal.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Evento implements Serializable {

    //declaracion variables
    private static final long serialVersionUID = 1L;
    private String Codigo;
    private String nombre;
    private String descripcion;
    private String fecha;
    private Integer capacidadMax;
    private String cedulaEmpleado;
    private Reserva reserva;
    ArrayList<Empleado> EmpleadosAsociados = new ArrayList<Empleado>();
    ArrayList<Reserva> ReservasAsociadas = new ArrayList<Reserva>();

    //constructor
    public Evento() {
    }


    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
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
