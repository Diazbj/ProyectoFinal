package co.edu.uniquindio.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Reserva;
import co.edu.uniquindio.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.model.Empleado;

public class EmpresaDeEventosUtils {
    public static EmpresaDeEventos inicializarDatos() {
        EmpresaDeEventos empresaDeEventos = new EmpresaDeEventos();
        Usuario usuario = new Usuario();
        usuario.setCedula("10946654");
        usuario.setNombre("Gonzalo");
        usuario.setCorreo("gonza@gmail.com");
        empresaDeEventos.getListaUsuarios().add(usuario);

        Empleado empleado = new Empleado();
        empleado.setCedula("12345");
        empleado.setNombre("juan");
        empleado.setCorreo("awdawd@gmail.com");
        empleado.setEvento("01");
        empresaDeEventos.getListaEmpleados().add(empleado);



        return empresaDeEventos;
    }
}
