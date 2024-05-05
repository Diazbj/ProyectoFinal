package co.edu.uniquindio.proyectofinal.model.services;

import co.edu.uniquindio.proyectofinal.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.exceptions.UsuarioException;
import co.edu.uniquindio.proyectofinal.model.Empleado;
import co.edu.uniquindio.proyectofinal.model.Usuario;

import java.util.ArrayList;

public interface IEmpresaDeEventosService {
    //----------------------------------------------Usuario------------------------------------------------
//    public Usuario crearUsuario(String cedula, String nombre,String correo ) throws UsuarioException;
//    public Boolean eliminarUsuario(String cedula) throws UsuarioException;
//    boolean actualizarUsuario(String cedulaActual, Usuario usuario)throws UsuarioException;
//    public boolean  verificarUsuarioExistente(String cedula)throws UsuarioException;
//    public Usuario obtenerUsuario(String cedula);
//    public ArrayList<Usuario> obtenerUsuarios();

    //----------------------------------------------Usuario------------------------------------------------

    //---------------------------------------------Empleado--------------------------------------------------
    public Empleado crearEmpleado( String nombre,String cedula, String correo)throws EmpleadoException;
    public Boolean eliminarEmpleado(String  cedula)throws EmpleadoException;
    boolean actualizarEmpleado(String cedulaActual, Empleado empleado)throws EmpleadoException;
    public boolean verificarEmpleadoExiste(String cedula) throws EmpleadoException;
    public Empleado obtenerEmpleado(String cedula);
    public ArrayList<Empleado> obtenerEmpleados();

    //---------------------------------------------Empleado--------------------------------------------------
}
