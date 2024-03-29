package co.edu.uniquindio.proyectofinal.model.services;

import co.edu.uniquindio.proyectofinal.exceptions.UsuarioException;
import co.edu.uniquindio.proyectofinal.model.Usuario;

import java.util.ArrayList;

public interface IEmpresaDeEventos {

    public Usuario crearUsuario(String cedula, String nombre,String correo ) throws UsuarioException;
    public Boolean eliminarUsuario(String cedula) throws UsuarioException;
    boolean actualizarUsuario(String cedulaActual, Usuario usuario)throws UsuarioException;
    public boolean  verificarUsuarioExistente(String cedula)throws UsuarioException;
    public Usuario obtenerUsuario(String cedula);
    public ArrayList<Usuario> obtenerUsuarios();

}
