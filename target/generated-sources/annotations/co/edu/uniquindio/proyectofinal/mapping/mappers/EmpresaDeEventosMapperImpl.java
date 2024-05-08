package co.edu.uniquindio.proyectofinal.mapping.mappers;

import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.model.Empleado;
import co.edu.uniquindio.proyectofinal.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-05T17:54:18-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
*/
public class EmpresaDeEventosMapperImpl implements EmpresaDeEventosMapper {

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nombre = null;
        String cedula = null;
        String correo = null;
        String reserva = null;

        UsuarioDto usuarioDto = new UsuarioDto( nombre, cedula, correo, reserva );

        return usuarioDto;
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        return usuario;
    }

    @Override
    public List<UsuarioDto> getUsuarioDto(List<Usuario> listUsuarios) {
        if ( listUsuarios == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( listUsuarios.size() );
        for ( Usuario usuario : listUsuarios ) {
            list.add( usuarioToUsuarioDto( usuario ) );
        }

        return list;
    }

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
}
