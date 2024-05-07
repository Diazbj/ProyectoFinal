package co.edu.uniquindio.proyectofinal.mapping.dto;


import co.edu.uniquindio.proyectofinal.model.Empleado;
import co.edu.uniquindio.proyectofinal.model.Reserva;

public record EventoDto(

        String codigo,
        String nombre,
        String descripcion,
        String fecha,
        String capacidadMax,
        String cedulaEmpleado,
        Reserva reserva

) {
}
