package co.edu.uniquindio.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.model.Empleado;

public class EmpresaDeEventosUtils {
    public static EmpresaDeEventos inicializarDatos() {
        EmpresaDeEventos empresaDeEventos = new EmpresaDeEventos();

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



        return empresaDeEventos;
    }
}
