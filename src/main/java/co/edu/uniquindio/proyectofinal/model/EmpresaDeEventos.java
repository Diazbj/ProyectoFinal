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
    public Boolean eliminarUsuario(String cedula)throws UsuarioException {
        Usuario usuario=null;
        boolean flagExiste=false;
        usuario=obtenerUsuario(cedula);
        if (usuario==null){
            throw new UsuarioException("El usuario a eliminar no existe");
        }else{
            getListaUsuarios().remove(usuario);
            flagExiste=true;
        }
        return flagExiste;
    }

    public void agregarUsuario(Usuario nuevoUsuario) throws UsuarioException{
        getListaUsuarios().add(nuevoUsuario);
    }

    @Override
    public boolean actualizarUsuario(String cedulaActual, Usuario usuario) throws UsuarioException {
        Usuario usuarioActual=obtenerUsuario(cedulaActual);
        if(usuarioActual==null){
            throw new UsuarioException("El usuario actual no existe");
        }else{
            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setCedula(usuario.getCedula());
            usuarioActual.setCorreo(usuario.getCorreo());
            return true;
        }

    }

    @Override
    public boolean verificarUsuarioExistente(String cedula) throws UsuarioException{
        if (usuarioExiste(cedula)){
            throw new UsuarioException("El usuario con cedula "+cedula+" ya existe");
        }else{
            return false;
        }
    }

    private boolean usuarioExiste(String cedula) {
        boolean usuarioEncontrado=false;
        for (Usuario usuario:getListaUsuarios()) {
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                usuarioEncontrado=true;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario obtenerUsuario(String cedula) {
        Usuario usuarioEncontrado=null;
        for (Usuario usuario:getListaUsuarios()) {
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                usuarioEncontrado=usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return getListaUsuarios();
    }
}
