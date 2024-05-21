package co.edu.uniquindio.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.EmpresaDeEventosApplication;
import co.edu.uniquindio.proyectofinal.utils.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LoginViewController {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnSignIn;

    @FXML
    private CheckBox cbAdministrador;

    @FXML
    private CheckBox cbEmpleado;

    @FXML
    private CheckBox cbUsuario;

    @FXML
    private TextField txtCedulaUp;

    @FXML
    private TextField txtClave;

    @FXML
    private TextField txtClaveUp;

    @FXML
    private TextField txtEmailUp;

    @FXML
    private TextField txtNombreUp;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtUsuarioUp;

    @FXML
    void onAdministrador(ActionEvent event) {

    }

    @FXML
    void onEmpleado(ActionEvent event) {

    }

    @FXML
    void onRegister(ActionEvent event) {

    }

    @FXML
    void onSignIn(ActionEvent event) {
        String usuario1=txtUsuario.getText();
        String contrasena1=txtClave.getText();

        boolean respuesta =leerDatosLogin(usuario1,contrasena1);

        if(respuesta==true){

            try{
                FXMLLoader fxmlLoader=new FXMLLoader(EmpresaDeEventosApplication.class.getResource("EmpresaDeEventosView.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensaje");
            alerta.setContentText("Sus datos son incorrectos");
            alerta.show();
        }

    }
    private List<String> cargarPropiedades() {
        return null;
    }


    public boolean leerDatosLogin(String txtUsuario, String txtClave){

        try {
            //PRoperties ResourceBundle
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/Persistencia/Log/Usuario.properties"));

            String usuario = properties.getProperty("usuario");
            String password = properties.getProperty("contrasena");

            if( txtUsuario.equals(usuario) && txtClave.equals(password) ){
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    @FXML
    void onUsuario(ActionEvent event) {

    }

}

