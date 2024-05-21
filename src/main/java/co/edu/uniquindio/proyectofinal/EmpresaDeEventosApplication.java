package co.edu.uniquindio.proyectofinal;

import co.edu.uniquindio.proyectofinal.mapping.mappers.EmpresaDeEventosMapper;
import co.edu.uniquindio.proyectofinal.viewController.EmpresaDeEventosViewController;
import co.edu.uniquindio.proyectofinal.viewController.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmpresaDeEventosApplication extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Login");
        mostrarVentanaPrincipal();
    }

    private void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EmpresaDeEventosApplication.class.getResource("Login.fxml"));
            AnchorPane rootLayout = loader.load();
            LoginViewController loginViewController = loader.getController();
            // loginViewController.setAplicacion(this); // Si necesitas pasar una referencia de la aplicación al controlador

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}