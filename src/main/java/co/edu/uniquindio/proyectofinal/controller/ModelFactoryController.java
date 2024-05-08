package co.edu.uniquindio.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyectofinal.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.exceptions.EventoException;
import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.EventoDto;
import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.utils.EmpresaDeEventosUtils;
import co.edu.uniquindio.proyectofinal.mapping.mappers.EmpresaDeEventosMapper;
import co.edu.uniquindio.proyectofinal.model.*;
import co.edu.uniquindio.proyectofinal.utils.Persistencia;

import java.io.IOException;
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
        //1. inicializar datos y luego guardarlo en archivos

        System.out.println("invocación clase singleton");
//        guardarRespaldo();
//       cargarDatosBase();
//      salvarDatosPrueba();

//        2. Cargar los datos de los archivos
//	cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
//		cargarResourceBinario();
//        guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
//		guardarResourceXML();
        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(empresaDeEventos == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");
    }
    private void guardarDatosEmpleados(){
        try{
            Persistencia.guardarEmpleados(getEmpresaDeEventos().getListaEmpleados());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void guardarDatosEventos(){
        try{
            Persistencia.guardarEventos(getEmpresaDeEventos().getListaEventos());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private void guardarRespaldo(){
        empresaDeEventos = new EmpresaDeEventos();
        Persistencia.guardarCopiaSeguridad();
    }

    private void cargarDatosDesdeArchivos() {
        empresaDeEventos = new EmpresaDeEventos();
        try {
            Persistencia.cargarDatosArchivos(empresaDeEventos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarEmpleados(getEmpresaDeEventos().getListaEmpleados());
            Persistencia.guardarEventos(getEmpresaDeEventos().getListaEventos());
           // Persistencia.guardarClientes(getBanco().getListaClientes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosBase() {
        empresaDeEventos = EmpresaDeEventosUtils.inicializarDatos();
    }

    public EmpresaDeEventos getEmpresaDeEventos(){return empresaDeEventos;}

    public void setEmpresaDeEventos(EmpresaDeEventos empresaDeEventos){this.empresaDeEventos = empresaDeEventos;}
//---------------------------------------------Usuario--------------------------------------------------
//    @Override
//    public List<UsuarioDto> obtenerUsuaios() {
//        return mapper.getUsuarioDto(empresaDeEventos.getListaUsuarios());
//    }
//
//    @Override
//    public boolean agregarUsuario(UsuarioDto usuarioDto) {
//        try{
//            if (!empresaDeEventos.verificarUsuarioExistente(usuarioDto.cedula())){
//                Usuario usuario=mapper.usuarioDtoToUsuario(usuarioDto);
//                getEmpresaDeEventos().agregarUsuario(usuario);
//            }
//            return true;
//        }catch (UsuarioException e) {
//            e.getMessage();
//            return false;
//        }
//    }
//
//    @Override
//    public boolean eliminarUsuario(String cedula) {
//
//        boolean flagExiste=false;
//        try {
//            flagExiste= getEmpresaDeEventos().eliminarUsuario(cedula);
//        }catch (UsuarioException e){
//
//            e.printStackTrace();
//
//        }
//
//        return flagExiste;
//    }
//
//    @Override
//    public boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto) {
//
//        try{
//            Usuario usuario=mapper.usuarioDtoToUsuario(usuarioDto);
//            getEmpresaDeEventos().actualizarUsuario(cedulaActual,usuario);
//            return true;
//        }catch (UsuarioException e){
//            e.printStackTrace();
//            return false;
//        }
//    }
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

            Persistencia.guardaRegistroLog("Agregar empleado", 1, "se agrego un empleado");
//            guardarDatosEmpleados();
            guardarResourceXML();
//            guardarResourceBinario();
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar el empleado");
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        boolean flagExiste = false;
        try{
            flagExiste = getEmpresaDeEventos().eliminarEmpleado(cedula);
//            guardarDatosEmpleados();
            guardarResourceXML();
//            guardarResourceBinario();
            Persistencia.guardaRegistroLog("Eliminar empleado", 1, "se elimino el empleado" );
        }catch (EmpleadoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al eliminar el empleado");
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        try{
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getEmpresaDeEventos().actualizarEmpleado(cedulaActual, empleado);
//            guardarDatosEmpleados();
            guardarResourceXML();
//            guardarResourceBinario();
            Persistencia.guardaRegistroLog("Actualizar empleado",  1 ,  "se actualizo el empleado");
            return true;
        }catch (EmpleadoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al actualizar empleado");
            return false;
        }

    }

    //---------------------------------------------Empleado--------------------------------------------------

    //---------------------------------------------Evento--------------------------------------------------

    @Override
    public List<EventoDto> obtenerEventos() {
        return mapper.getEventoDto(empresaDeEventos.getListaEventos());
    }

    @Override
    public boolean agregarEvento(EventoDto eventoDto) {
        try{
            if (!empresaDeEventos.verificarEventoExiste(eventoDto.codigo())){
                Evento evento = mapper.eventoDtoToEvento(eventoDto);
                getEmpresaDeEventos().agregarEvento(evento);

            }
            Persistencia.guardaRegistroLog("Agregar evento", 1, "se agrego el evento");
            guardarResourceXML();
            guardarResourceBinario();
//            guardarDatosEventos();
            return true;
        }catch (EventoException e){
            e.getMessage();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar evento");
            return false;
        }
    }

    @Override
    public boolean eliminarEventos(String codigo) {
        boolean flagExiste = false;
        try{
            flagExiste = getEmpresaDeEventos().eliminarEvento(codigo);
            guardarResourceXML();
            guardarResourceBinario();
//            guardarDatosEventos();
            Persistencia.guardaRegistroLog("Eliminar evento", 1 , "se elimino un evento");
        }catch (EventoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3 , "fallo al eliminar evento");
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEventos(String idActual, EventoDto eventoDto) {
        try{
            Evento evento = mapper.eventoDtoToEvento(eventoDto);
            getEmpresaDeEventos().actualizarEvento(idActual, evento);
            guardarResourceXML();
            guardarResourceBinario();
//            guardarDatosEventos();
            Persistencia.guardaRegistroLog("Actualizar evento", 1, "se actualizo el evento");
            return true;
        }catch (EventoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al actualizar el evento");
            return false;
        }
    }

    //---------------------------------------------Evento--------------------------------------------------

    private void cargarResourceXML() {
        empresaDeEventos = Persistencia.cargarRecursoEmpresaDeEventosXML();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoEmpresaDeEventosXML(empresaDeEventos);
    }

    private void cargarResourceBinario() {
        empresaDeEventos = Persistencia.cargarRecursoEmpresaDeEventosBinario();
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoEmpresaDeEventosBinario(empresaDeEventos);
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
}
