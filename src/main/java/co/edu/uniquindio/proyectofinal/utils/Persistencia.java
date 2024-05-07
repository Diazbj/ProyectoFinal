package co.edu.uniquindio.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.exceptions.*;
import co.edu.uniquindio.proyectofinal.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Persistencia {


    //bancoUq/src/main/resources/persistencia/archivoClientes.txt
    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_EMPLEADOS = "src/main/resources/persistencia/archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_EVENTO = "src/main/resources/Persistencia/archivoEvento.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "/src/main/resources/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/Persistencia/Log/EmpresaDeEventosLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_EMPRESA_DE_EVENTOS_BINARIO = "src/main/resources/Persistencia/model.data";
    public static final String RUTA_ARCHIVO_MODELO_EMPRESA_DE_EVENTOS_XML = "src/main/resources/Persistencia/model.xml";
    public static final String RUTA_RESPALDO_ARCHIVO_EMPLEADOS ="src/main/resources/Persistencia/Respaldo/respaldoEmpleado";
//	C:\td\persistencia



    public static void cargarDatosArchivos(EmpresaDeEventos empresaDeEventos) throws FileNotFoundException, IOException {
        //cargar archivo de usuarios
        //ArrayList<Usuario> usuariosCargados = cargarUsuarios();
        //if(usuariosCargados.size() > 0)
          //  empresaDeEventos.getListaUsuarios().addAll(usuariosCargados);

        //cargar archivos empleados
        ArrayList<Empleado> empleadosCargados = cargarEmpleados();
        if(empleadosCargados.size() > 0)
            empresaDeEventos.getListaEmpleados().addAll(empleadosCargados);

        ArrayList<Evento> eventosCargados = cargarEventos();
        if(eventosCargados.size()>0)
            empresaDeEventos.getListaEventos().addAll(eventosCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    //--------------------------------------Eventos--------------------------------------
    public  static void guardarEventos(ArrayList<Evento> listaEventos)throws IOException{
        String contenido = "";
        for (Evento evento: listaEventos){
            contenido += evento.getCodigo()+ "@@" + evento.getNombre() + "@@" + evento.getDescripcion() + "@@" +
                    evento.getFecha() + "@@" + evento.getCapacidadMax() + "@@" + evento.getCedulaEmpleado() +
                    "@@" + evento.getReserva().getCodigo() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EVENTO, contenido, false);
    }

    public static ArrayList<Evento> cargarEventos()throws FileNotFoundException, IOException{
        ArrayList<Evento> eventos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EVENTO);
        String linea = "";
        Empleado empleado = new Empleado();
        Reserva reserva = new Reserva();
        for (int i = 0; i<contenido.size(); i++){
            linea = contenido.get(i);
            Evento evento = new Evento();
            evento.setCodigo(linea.split("@@")[0]);
            evento.setNombre(linea.split("@@")[1]);
            evento.setDescripcion(linea.split("@@")[2]);
            evento.setFecha(linea.split("@@")[3]);
            evento.setCapacidadMax(Integer.valueOf(linea.split("@@")[4]));
            evento.setCedulaEmpleado(linea.split("@@")[5]);
//            reserva.setId(linea.split("@@")[6]);
//            evento.setEmpleado(empleado);
//            evento.setReserva(reserva);
            eventos.add(evento);

        }

        return eventos;
    }
    //--------------------------------------Eventos--------------------------------------
    public static void guardarCopiaSeguridad() {
        try {
            // Convertir las rutas de cadena a objetos de Path
            Path archivoEmpleados = Paths.get(RUTA_ARCHIVO_EMPLEADOS);
            Path archivoRespaldo = Paths.get(RUTA_RESPALDO_ARCHIVO_EMPLEADOS);
//            Path archivoUsuarios = Paths.get(RUTA_ARCHIVO_USUARIO);
//            Path archivoRespaldoUsuarios = Paths.get(RUTA_RESPALDO_ARCHIVO_USUARIOS);
//            Path archivoReservas = Paths.get(RUTA_ARCHIVO_RESERVA);
//            Path archivoRespaldoReservas = Paths.get(RUTA_RESPALDO_ARCHIVO_RESERVAS);
//            Path archivoEventos = Paths.get(RUTA_ARCHIVO_EVENTO);
//            Path archivoRespaldoEventos = Paths.get(RUTA_RESPALDO_ARCHIVO_EVENTOS);

            // Verificar si los archivos de respaldo existen y eliminarlos si es así
//            if (Files.exists(archivoRespaldo)) Files.delete(archivoRespaldo);
//            if (Files.exists(archivoRespaldoUsuarios)) Files.delete(archivoRespaldoUsuarios);
//            if (Files.exists(archivoRespaldoReservas)) Files.delete(archivoRespaldoReservas);
//            if (Files.exists(archivoRespaldoEventos)) Files.delete(archivoRespaldoEventos);

            // Copiar el archivo
            Files.copy(archivoEmpleados, archivoRespaldo);
//            Files.copy(archivoUsuarios, archivoRespaldoUsuarios);
//            Files.copy(archivoReservas, archivoRespaldoReservas);
//            Files.copy(archivoEventos, archivoRespaldoEventos);

            System.out.println("¡Copia de seguridad creada exitosamente!");
        } catch (IOException e) {
            System.err.println("Error al crear la copia de seguridad: " + e.getMessage());
        }
    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
//   public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
//        // TODO Auto-generated method stub
//       String contenido = "";
//       for(Cliente cliente:listaClientes)
//       {
//           contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
//                    +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
//        }
//        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
//    }


    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
        String contenido = "";
        for(Empleado empleado:listaEmpleados)
        {
            contenido+= empleado.getNombre()+
                    "@@"+empleado.getCedula()+
                    "@@"+empleado.getCorreo()+
                    "@@"+empleado.getEvento()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }



//	----------------------LOADS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
//    public static ArrayList<Cliente> cargarClientes() throws FileNotFoundException, IOException
//    {
//        ArrayList<Cliente> clientes =new ArrayList<Cliente>();
//        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
//        String linea="";
//        for (int i = 0; i < contenido.size(); i++)
//        {
//            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
//            Cliente cliente = new Cliente();
//            cliente.setNombre(linea.split(",")[0]);
//            cliente.setApellido(linea.split(",")[1]);
//            cliente.setCedula(linea.split(",")[2]);
//            cliente.setDireccion(linea.split(",")[3]);
//            cliente.setCorreo(linea.split(",")[4]);
//            cliente.setFechaNacimiento(linea.split(",")[5]);
//            cliente.setTelefono(linea.split(",")[6]);
//            clientes.add(cliente);
//        }
//        return clientes;
//    }


    public static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {
        ArrayList<Empleado> empleados =new ArrayList<Empleado>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);
            Empleado empleado = new Empleado();
            empleado.setNombre(linea.split("@@")[0]);
            empleado.setCedula(linea.split("@@")[1]);
            empleado.setCorreo(linea.split("@@")[2]);
            empleado.setEvento(linea.split("@@")[3]);
            empleados.add(empleado);
        }
        return empleados;
    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioException {

        if(validarUsuario(usuario,contrasenia)) {
            return true;
        }else {
            throw new UsuarioException("Usuario no existe");
        }

    }

    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException
    {
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
        {
            Usuario usuarioAux = usuarios.get(indiceUsuario);
            if(usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios =new ArrayList<Usuario>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
        String linea="";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Usuario usuario = new Usuario();
            usuario.setUsuario(linea.split("@@")[0]);
            usuario.setContrasenia(linea.split("@@")[1]);

            usuarios.add(usuario);
        }
        return usuarios;
    }


//	----------------------SAVES------------------------

//    /**
//     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
//     * @param
//     * @param ruta
//     * @throws IOException
//     */

//    public static void guardarObjetos(ArrayList<Cliente> listaClientes, String ruta) throws IOException  {
//        String contenido = "";
//
//        for(Cliente clienteAux:listaClientes) {
//            contenido+= clienteAux.getNombre()+","+clienteAux.getApellido()+","+clienteAux.getCedula()+clienteAux.getDireccion()
//                    +","+clienteAux.getCorreo()+","+clienteAux.getFechaNacimiento()+","+clienteAux.getTelefono()+"\n";
//        }
//        ArchivoUtil.guardarArchivo(ruta, contenido, true);
//    }





    //------------------------------------SERIALIZACIÓN  y XML


    public static EmpresaDeEventos cargarRecursoEmpresaDeEventosBinario() {

        EmpresaDeEventos empresaDeEventos = null;

        try {
            empresaDeEventos = (EmpresaDeEventos)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_EMPRESA_DE_EVENTOS_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return empresaDeEventos;
    }

    public static void guardarRecursoEmpresaDeEventosBinario(EmpresaDeEventos empresaDeEventos) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_EMPRESA_DE_EVENTOS_BINARIO, empresaDeEventos);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static EmpresaDeEventos cargarRecursoEmpresaDeEventosXML() {

        EmpresaDeEventos empresaDeEventos = null;

        try {
            empresaDeEventos = (EmpresaDeEventos)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_EMPRESA_DE_EVENTOS_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return empresaDeEventos;

    }



    public static void guardarRecursoEmpresaDeEventosXML(EmpresaDeEventos empresaDeEventos) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_EMPRESA_DE_EVENTOS_XML, empresaDeEventos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }










}

