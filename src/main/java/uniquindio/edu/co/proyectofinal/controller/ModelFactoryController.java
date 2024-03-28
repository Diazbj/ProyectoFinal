package uniquindio.edu.co.proyectofinal.controller;

import uniquindio.edu.co.proyectofinal.controller.service.IModelFactoryService;
import uniquindio.edu.co.proyectofinal.mapping.dto.UsuarioDto;
import uniquindio.edu.co.proyectofinal.model.Usuario;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
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
