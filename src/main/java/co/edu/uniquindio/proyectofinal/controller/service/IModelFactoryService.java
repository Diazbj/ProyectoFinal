package co.edu.uniquindio.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.model.Usuario;

import java.util.List;

public interface IModelFactoryService {

//    List<UsuarioDto> obtenerUsuaios();
//
//    boolean agregarUsuario(UsuarioDto usuarioDto);
//
//    boolean eliminarUsuario(String cedula);
//
//    boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto);

    List<EmpleadoDto> obtenerEmpleados();
    boolean agregarEmpleado(EmpleadoDto empleadoDto);
    boolean eliminarEmpleado(String id);
    boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto);

}
