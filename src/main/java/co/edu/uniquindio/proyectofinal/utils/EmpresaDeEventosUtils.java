package co.edu.uniquindio.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Evento;
import co.edu.uniquindio.proyectofinal.model.Empleado;

import java.time.LocalDate;

public class EmpresaDeEventosUtils {
    public static EmpresaDeEventos inicializarDatos() {
        EmpresaDeEventos empresaDeEventos = new EmpresaDeEventos();
//--------------------------------------Empleados Utils--------------------------------------------------------------------
        Empleado empleado = new Empleado();
        empleado.setNombre("jordy");
        empleado.setCedula("12345");
        empleado.setCorreo("jordy@gmail.com");
        empleado.setEvento("01");
        empresaDeEventos.getListaEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("david");
        empleado.setCedula("123456");
        empleado.setCorreo("david@gmail.com");
        empleado.setEvento("02");
        empresaDeEventos.getListaEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Gonzalo");
        empleado.setCedula("1234567");
        empleado.setCorreo("gonza@gmail.com");
        empleado.setEvento("03");
        empresaDeEventos.getListaEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Alberto");
        empleado.setCedula("12345678");
        empleado.setCorreo("Albert@gmail.com");
        empleado.setEvento("04");
        empresaDeEventos.getListaEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Jennifer");
        empleado.setCedula("123456789");
        empleado.setCorreo("jenn@gmail.com");
        empleado.setEvento("05");
        empresaDeEventos.getListaEmpleados().add(empleado);
        System.out.println("Información de los empleados creada");
//--------------------------------------Empleados Utils--------------------------------------------------------------------

//--------------------------------------Eventos Utils----------------------------------------------------------------------
        Evento evento = new Evento();
        evento.setCodigo("10");
        evento.setNombre("Concierto");
        evento.setDescripcion("bandas de rock");
        evento.setFecha(LocalDate.now().toString());
        evento.setCapacidadMax(1000);
        evento.setCedulaEmpleado(empresaDeEventos.getListaEmpleados().get(1).getCedula());
        empresaDeEventos.getListaEventos().add(evento);

        evento = new Evento();
        evento.setCodigo("08");
        evento.setNombre("Evento Social");
        evento.setDescripcion("Matrimonio");
        evento.setFecha(LocalDate.now().toString());
        evento.setCapacidadMax(200);
        evento.setCedulaEmpleado(empresaDeEventos.getListaEmpleados().get(0).getCedula());
        empresaDeEventos.getListaEventos().add(evento);

//--------------------------------------Eventos Utils------------------------------------------------------------------------

        return empresaDeEventos;
    }
}
