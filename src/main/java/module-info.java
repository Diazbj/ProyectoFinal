module uniquindio.edu.co.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal;
    exports co.edu.uniquindio.proyectofinal.viewController;
    opens co.edu.uniquindio.proyectofinal.viewController to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.controller;
    exports co.edu.uniquindio.proyectofinal.mapping.dto;
    exports co.edu.uniquindio.proyectofinal.mapping.mappers;
    exports co.edu.uniquindio.proyectofinal.model;
    opens co.edu.uniquindio.proyectofinal.controller to javafx.fxml;
}