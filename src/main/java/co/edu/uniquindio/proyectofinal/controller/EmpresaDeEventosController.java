package co.edu.uniquindio.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.controller.service.IEmpresaDeEventosControllerService;

public class EmpresaDeEventosController implements IEmpresaDeEventosControllerService {

    ModelFactoryController modelFactoryController;

    public EmpresaDeEventosController(){
        System.out.println("LLamando al sigleton desde EmpresaDeEventosController");

        modelFactoryController=ModelFactoryController.getInstance();
    }
}
