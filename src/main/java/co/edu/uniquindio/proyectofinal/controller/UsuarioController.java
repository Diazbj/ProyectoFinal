package co.edu.uniquindio.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.controller.service.IUsuarioControllerService;
import co.edu.uniquindio.proyectofinal.mapping.dto.UsuarioDto;

import java.util.List;

public class UsuarioController implements IUsuarioControllerService {

    ModelFactoryController modelFactoryController;

    public UsuarioController(){modelFactoryController=ModelFactoryController.getInstance();}


    public List<UsuarioDto> obtenerusuarios() {
        return modelFactoryController.obtenerUsuaio();
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
