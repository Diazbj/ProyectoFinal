package co.edu.uniquindio.proyectofinal;

import co.edu.uniquindio.proyectofinal.controller.ModelFactoryController;
import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class MainEmpresaDeEventos {
    public static void main(String[] arsg){
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

        EmpleadoDto empleadoDto = new EmpleadoDto(
                "123456",
                "juan",
                "sdasf"

        );

        if (modelFactoryController.agregarEmpleado(empleadoDto)){
            System.out.println("No existe se agrego correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<EmpleadoDto> empleadoDtoList = modelFactoryController.obtenerEmpleados();
        empleadoDtoList.forEach(System.out::println);
    }
}