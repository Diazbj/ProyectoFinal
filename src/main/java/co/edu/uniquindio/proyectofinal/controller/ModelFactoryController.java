package co.edu.uniquindio.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyectofinal.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.exceptions.UsuarioException;
import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.utils.EmpresaDeEventosUtils;
import co.edu.uniquindio.proyectofinal.mapping.mappers.EmpresaDeEventosMapper;
import co.edu.uniquindio.proyectofinal.model.*;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    EmpresaDeEventos empresaDeEventos;

    EmpresaDeEventosMapper mapper =EmpresaDeEventosMapper.INSTANCE;


    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){
        System.out.println("invocacion clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        empresaDeEventos = EmpresaDeEventosUtils.inicializarDatos();
    }

    public EmpresaDeEventos getEmpresaDeEventos(){return empresaDeEventos;}

    public void setEmpresaDeEventos(EmpresaDeEventos empresaDeEventos){this.empresaDeEventos = empresaDeEventos;}
//---------------------------------------------Usuario--------------------------------------------------
    @Override
    public List<UsuarioDto> obtenerUsuaios() {
        return mapper.getUsuarioDto(empresaDeEventos.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if (!empresaDeEventos.verificarUsuarioExistente(usuarioDto.cedula())){
                Usuario usuario=mapper.usuarioDtoToUsuario(usuarioDto);
                getEmpresaDeEventos().agregarUsuario(usuario);
            }
            return true;
        }catch (UsuarioException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String cedula) {

        boolean flagExiste=false;
        try {
            flagExiste= getEmpresaDeEventos().eliminarUsuario(cedula);
        }catch (UsuarioException e){

            e.printStackTrace();

        }

        return flagExiste;
    }

    @Override
    public boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto) {

        try{
            Usuario usuario=mapper.usuarioDtoToUsuario(usuarioDto);
            getEmpresaDeEventos().actualizarUsuario(cedulaActual,usuario);
            return true;
        }catch (UsuarioException e){
            e.printStackTrace();
            return false;
        }
    }
    //---------------------------------------------Usuario--------------------------------------------------

    //---------------------------------------------Empleado--------------------------------------------------
    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return mapper.getEmpleadosDto(empresaDeEventos.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if (!empresaDeEventos.verificarEmpleadoExiste(empleadoDto.cedula())){
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getEmpresaDeEventos().agregarEmpleado(empleado);

            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        boolean flagExiste = false;
        try{
            flagExiste = getEmpresaDeEventos().eliminarEmpleado(cedula);
        }catch (EmpleadoException e){
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        try{
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getEmpresaDeEventos().actualizarEmpleado(cedulaActual, empleado);
            return true;
        }catch (EmpleadoException e){
            e.printStackTrace();
            return false;
        }

    }

    //---------------------------------------------Empleado--------------------------------------------------
}
