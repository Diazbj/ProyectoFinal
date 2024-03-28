package co.edu.uniquindio.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.controller.EmpresaDeEventosController;
import co.edu.uniquindio.proyectofinal.controller.service.IEmpresaDeEventosControllerService;
import javafx.fxml.FXML;

public class EmpresaDeEventosViewController {

    IEmpresaDeEventosControllerService empresaDeEventosControllerService;

    @FXML
    void initialize(){
        empresaDeEventosControllerService=new EmpresaDeEventosController();
    }

}
