package co.edu.uniquindio.proyectofinal.mapping.mappers;

import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.EventoDto;
import co.edu.uniquindio.proyectofinal.model.Empleado;
import co.edu.uniquindio.proyectofinal.model.Evento;
import co.edu.uniquindio.proyectofinal.model.Reserva;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T09:55:44-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
*/
public class EmpresaDeEventosMapperImpl implements EmpresaDeEventosMapper {

    @Override
    public EmpleadoDto empleadoToEmpleadoDto(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        String nombre = null;
        String cedula = null;
        String correo = null;
        String evento = null;

        nombre = empleado.getNombre();
        cedula = empleado.getCedula();
        correo = empleado.getCorreo();
        evento = empleado.getEvento();

        EmpleadoDto empleadoDto = new EmpleadoDto( nombre, cedula, correo, evento );

        return empleadoDto;
    }

    @Override
    public Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto) {
        if ( empleadoDto == null ) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setNombre( empleadoDto.nombre() );
        empleado.setCedula( empleadoDto.cedula() );
        empleado.setCorreo( empleadoDto.correo() );
        empleado.setEvento( empleadoDto.evento() );

        return empleado;
    }

    @Override
    public List<EmpleadoDto> getEmpleadosDto(List<Empleado> listsEmpleados) {
        if ( listsEmpleados == null ) {
            return null;
        }

        List<EmpleadoDto> list = new ArrayList<EmpleadoDto>( listsEmpleados.size() );
        for ( Empleado empleado : listsEmpleados ) {
            list.add( empleadoToEmpleadoDto( empleado ) );
        }

        return list;
    }

    @Override
    public EventoDto eventoToEventoDto(Evento evento) {
        if ( evento == null ) {
            return null;
        }

        String codigo = null;
        String nombre = null;
        String descripcion = null;
        String fecha = null;
        String capacidadMax = null;
        String cedulaEmpleado = null;
        Reserva reserva = null;

        codigo = evento.getCodigo();
        nombre = evento.getNombre();
        descripcion = evento.getDescripcion();
        fecha = evento.getFecha();
        if ( evento.getCapacidadMax() != null ) {
            capacidadMax = String.valueOf( evento.getCapacidadMax() );
        }
        cedulaEmpleado = evento.getCedulaEmpleado();
        reserva = evento.getReserva();

        EventoDto eventoDto = new EventoDto( codigo, nombre, descripcion, fecha, capacidadMax, cedulaEmpleado, reserva );

        return eventoDto;
    }

    @Override
    public Evento eventoDtoToEvento(EventoDto eventoDto) {
        if ( eventoDto == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setCedulaEmpleado( eventoDto.cedulaEmpleado() );
        evento.setReserva( eventoDto.reserva() );
        evento.setCodigo( eventoDto.codigo() );
        evento.setNombre( eventoDto.nombre() );
        evento.setDescripcion( eventoDto.descripcion() );
        evento.setFecha( eventoDto.fecha() );
        if ( eventoDto.capacidadMax() != null ) {
            evento.setCapacidadMax( Integer.parseInt( eventoDto.capacidadMax() ) );
        }

        return evento;
    }

    @Override
    public List<EventoDto> getEventoDto(List<Evento> listsEventos) {
        if ( listsEventos == null ) {
            return null;
        }

        List<EventoDto> list = new ArrayList<EventoDto>( listsEventos.size() );
        for ( Evento evento : listsEventos ) {
            list.add( eventoToEventoDto( evento ) );
        }

        return list;
    }
}
