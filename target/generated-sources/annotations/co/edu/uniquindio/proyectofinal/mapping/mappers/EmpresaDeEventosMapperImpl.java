package co.edu.uniquindio.proyectofinal.mapping.mappers;

import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-31T17:20:10-0500",
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

        nombre = usuario.getNombre();
        cedula = usuario.getCedula();
        correo = usuario.getCorreo();

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

        usuario.setNombre( usuarioDto.nombre() );
        usuario.setCedula( usuarioDto.cedula() );
        usuario.setCorreo( usuarioDto.correo() );

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
}
