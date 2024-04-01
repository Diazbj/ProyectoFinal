package co.edu.uniquindio.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoControllerService {
    List<EmpleadoDto> obtenerEmpleados();
    boolean agregarEmpleado(EmpleadoDto empleadoDto);
    boolean eliminarEmpleado(String id);
    boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto);
}
