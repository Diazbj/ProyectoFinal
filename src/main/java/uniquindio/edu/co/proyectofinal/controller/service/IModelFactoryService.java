package uniquindio.edu.co.proyectofinal.controller.service;

import uniquindio.edu.co.proyectofinal.mapping.dto.UsuarioDto;
import uniquindio.edu.co.proyectofinal.model.Usuario;

import java.util.List;

public interface IModelFactoryService {

    List<Usuario> obtenerUsuaio();

    boolean agregarUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(String cedula);

    boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto);

}
