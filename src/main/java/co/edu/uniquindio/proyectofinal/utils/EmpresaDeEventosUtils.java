package co.edu.uniquindio.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Reserva;
import co.edu.uniquindio.proyectofinal.model.Usuario;

public class EmpresaDeEventosUtils {
    public static EmpresaDeEventos inicializarDatos() {
        EmpresaDeEventos empresaDeEventos = new EmpresaDeEventos();
        Usuario usuario = new Usuario();
        usuario.setCedula("10946654");
        usuario.setNombre("Gonzalo");
        usuario.setCorreo("gonza@gmail.com");
        empresaDeEventos.getListaUsuarios().add(usuario);



        return empresaDeEventos;
    }
}
