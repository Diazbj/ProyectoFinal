package co.edu.uniquindio.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.exceptions.UsuarioException;
import co.edu.uniquindio.proyectofinal.model.services.IEmpresaDeEventosService;

import java.util.ArrayList;

public class EmpresaDeEventos implements IEmpresaDeEventosService {

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

    //----------------------------------------------Usuario------------------------------------------------
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
    //----------------------------------------------Usuario------------------------------------------------

    //---------------------------------------------Empleado--------------------------------------------------
    @Override
    public Empleado crearEmpleado( String nombre,String cedula, String correo) throws EmpleadoException {
        Empleado nuevoEmpleado = null;
        boolean empleadoExiste = verificarEmpleadoExiste(cedula);
        if (empleadoExiste){
            throw new EmpleadoException("El empleado con ID: " + cedula + " ya existe.");
        }else {
            nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setCedula(cedula);
            nuevoEmpleado.setCorreo(correo);
            getListaEmpleados().add(nuevoEmpleado);

        }
        return nuevoEmpleado;
    }

    public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException{
        getListaEmpleados().add(nuevoEmpleado);
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, Empleado empleado) throws EmpleadoException {
        Empleado empleadoActual = obtenerEmpleado(cedulaActual);
        if (empleadoActual == null){
            throw  new EmpleadoException("El empleado a actualizar no existe");
        }else{
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setCedula(empleado.getCedula());
            empleadoActual.setCorreo(empleado.getCorreo());
            return true;
        }

    }

    @Override
    public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
        Empleado empleado = null;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(cedula);
        if (empleado == null)
            throw  new EmpleadoException("El empleado a eliminar no existe");
        else {
            getListaEmpleados().remove(empleado);
            flagExiste = true;
        }
        return flagExiste;
    }



    @Override
    public boolean verificarEmpleadoExiste(String cedula) throws EmpleadoException {
        if (empleadoExiste(cedula)){
            throw new EmpleadoException("El empleado con cedula: " + cedula + " ya existe");
        }else {
            return false;
        }

    }

    @Override
    public Empleado obtenerEmpleado(String cedula) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()){
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }

    public  boolean empleadoExiste(String cedula){
        boolean empleadoEncontrado = false;
        for (Empleado empleado : getListaEmpleados()){
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = true;
                break;
            }
        }
        return  empleadoEncontrado;
    }
    //---------------------------------------------Empleado--------------------------------------------------
}
