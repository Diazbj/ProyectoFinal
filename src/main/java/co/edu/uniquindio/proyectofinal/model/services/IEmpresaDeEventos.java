package co.edu.uniquindio.proyectofinal.model.services;

import co.edu.uniquindio.proyectofinal.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.exceptions.UsuarioException;
import co.edu.uniquindio.proyectofinal.model.Empleado;
import co.edu.uniquindio.proyectofinal.model.Usuario;

import java.util.ArrayList;

public interface IEmpresaDeEventos {
    //----------------------------------------------Usuario------------------------------------------------
    public Usuario crearUsuario(String cedula, String nombre,String correo ) throws UsuarioException;
    public Boolean eliminarUsuario(String cedula) throws UsuarioException;
    boolean actualizarUsuario(String cedulaActual, Usuario usuario)throws UsuarioException;
    public boolean  verificarUsuarioExistente(String cedula)throws UsuarioException;
    public Usuario obtenerUsuario(String cedula);
    public ArrayList<Usuario> obtenerUsuarios();

    //----------------------------------------------Usuario------------------------------------------------

    //---------------------------------------------Empleado--------------------------------------------------
    public Empleado crearEmpleado(String id, String nombre, String correo)throws EmpleadoException;
    public Boolean eliminarEmpleado(String  id)throws EmpleadoException;
    boolean actualizarEmpleado(String idActual, Empleado empleado)throws EmpleadoException;
    public boolean verificarEmpleadoExiste(String id) throws EmpleadoException;
    public Empleado obtenerEmpleado(String id);
    public ArrayList<Empleado> obtenerEmpleados();

    //---------------------------------------------Empleado--------------------------------------------------
}
