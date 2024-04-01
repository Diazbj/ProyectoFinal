package co.edu.uniquindio.proyectofinal.mapping.mappers;

import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.model.Empleado;
import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpresaDeEventosMapper {

    EmpresaDeEventosMapper INSTANCE = Mappers.getMapper(EmpresaDeEventosMapper.class);
//----------------------------------------------Usuario------------------------------------------------
    @Named("usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuarioDto(List<Usuario> listUsuarios);

//----------------------------------------------Usuario-------------------------------------------------

    //----------------------------------------Empleado--------------------------------------------------
    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listsEmpleados);
//---------------------------------------------Empleado---------------------------------------------
}
