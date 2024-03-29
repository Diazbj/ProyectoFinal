package co.edu.uniquindio.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.exceptions.UsuarioException;
import co.edu.uniquindio.proyectofinal.model.services.IEmpresaDeEventos;

import java.util.ArrayList;

public class EmpresaDeEventos implements IEmpresaDeEventos {

    private static final long serialVersionUID=1L;

    ArrayList<Usuario> listaUsuarios=new ArrayList<>();
    ArrayList<Empleado> listaEmpleados=new ArrayList<>();
    ArrayList<Evento> ListaEventos=new ArrayList<>();
    ArrayList<Reserva> listaReservas=new ArrayList<>();

    public EmpresaDeEventos(){

    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Evento> getListaEventos() {
        return ListaEventos;
    }

    public void setListaEventos(ArrayList<Evento> listaEventos) {
        ListaEventos = listaEventos;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public Usuario crearUsuario(String cedula, String nombre,String correo) throws UsuarioException {
        Usuario nuevoUsuario=null;
        boolean usuarioExiste=verificarUsuarioExistente(cedula);
        if(usuarioExiste){
            throw new UsuarioException("El Usuario con cedula: "+cedula+" ya existe");
        }else{
            nuevoUsuario=new Usuario();
            nuevoUsuario.setCedula(cedula);
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setCorreo(correo);
            getListaUsuarios().add(nuevoUsuario);

        }
        return nuevoUsuario;
    }

    @Override
    public Boolean eliminarUsuario(String cedula) {
        return null;
    }

    @Override
    public boolean actualizarUsuario(String cedulaActual, Usuario usuario) {
        return false;
    }

    @Override
    public boolean verificarUsuarioExistente(String cedula) {
        return false;
    }

    @Override
    public Usuario obtenerUsuario(String cedula) {
        return null;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return null;
    }
}
