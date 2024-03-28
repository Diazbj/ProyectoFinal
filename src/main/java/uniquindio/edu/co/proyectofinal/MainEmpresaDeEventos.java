package uniquindio.edu.co.proyectofinal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainEmpresaDeEventos {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}