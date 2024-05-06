package co.edu.uniquindio.proyectofinal.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EventoViewController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<?> tableEventos;

    @FXML
    private TableColumn<?, ?> tcCapacidad;

    @FXML
    private TableColumn<?, ?> tcCodigo;

    @FXML
    private TableColumn<?, ?> tcDescripcion;

    @FXML
    private TableColumn<?, ?> tcEmpleado;

    @FXML
    private TableColumn<?, ?> tcFecha;

    @FXML
    private TableColumn<?, ?> tcNombre;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtEmpleado;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtNombre;

}
