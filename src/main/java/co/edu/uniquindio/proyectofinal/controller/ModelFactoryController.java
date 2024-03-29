package co.edu.uniquindio.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.model.EmpresaDeEventos;
import co.edu.uniquindio.proyectofinal.model.Usuario;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    EmpresaDeEventos empresaDeEventos;



    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    @Override
    public List<Usuario> obtenerUsuaio() {
        return null;
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(String cedula) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto) {
        return false;
    }
}
