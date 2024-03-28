package co.edu.uniquindio.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.model.Usuario;

import java.util.List;

public interface IModelFactoryService {

    List<Usuario> obtenerUsuaio();

    boolean agregarUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(String cedula);

    boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto);

}
