package co.edu.uniquindio.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.controller.EmpleadoController;
import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmpleadoViewController {



    EmpleadoController empleadoControllerService;
    ObservableList<EmpleadoDto> listaEmpleadosDto = FXCollections.observableArrayList();
    EmpleadoDto empleadoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bntActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<EmpleadoDto> tbEmpleados;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCorreo;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCedula;

    @FXML
    private TableColumn<EmpleadoDto, String> tcNombre;

    @FXML
    private TableColumn<EmpleadoDto, String> tcEvento;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;


    @FXML
    void initialize(){
        empleadoControllerService = new EmpleadoController();
        intiView();
    }
    private void intiView(){
        initDataBinding();
        obtenerEmpleados();
        tbEmpleados.getItems().clear();
        tbEmpleados.setItems(listaEmpleadosDto);
        listenerSelection();
    }

    private void initDataBinding(){

        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        tcEvento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().evento()));


    }

    private void obtenerEmpleados(){ listaEmpleadosDto.addAll(empleadoControllerService.obtenerEmpleados());}

    private void listenerSelection(){
        tbEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }
    private void mostrarInformacionEmpleado(EmpleadoDto empleadoSeleccionado){
        if(empleadoSeleccionado != null){

            txtNombre.setText(empleadoSeleccionado.nombre());
            txtCedula.setText(empleadoSeleccionado.cedula());
            txtCorreo.setText(empleadoSeleccionado.correo());
            txtCodigo.setText(empleadoSeleccionado.evento());
        }
    }

    @FXML
    void nuevoEmpleadoAction(ActionEvent event) {

        txtNombre.setText("Ingrese el nombre");
        txtCedula.setText("Ingrese la cedula");
        txtCorreo.setText("Ingrese el correo");
        txtCodigo.setText("Ingrese el codigo de el evento asignado");
    }

    @FXML
    void agregarEmpleadoAction(ActionEvent event) {
        crearEmpleado();
    }

    @FXML
    void eliminarEmpleadoAction(ActionEvent event) {
        eliminarEmpleado();
    }
    @FXML
    void actualizarEmpleadoAction(ActionEvent event) {
        actualizarEmpleado();
    }

    private void crearEmpleado(){
        EmpleadoDto empleadoDto = construirEmpleadoDto();

        if(datosValidos(empleadoDto)){
            if(empleadoControllerService.agregarEmpleado(empleadoDto)){
                listaEmpleadosDto.add(empleadoDto);
                mostrarMensaje("Notificacion empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarEmpleado() {
        boolean empleadoEliminado = false;
        if(empleadoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?")){
                empleadoEliminado = empleadoControllerService.eliminarEmpleado(empleadoSeleccionado.cedula());
                if(empleadoEliminado == true){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    empleadoSeleccionado = null;
                    tbEmpleados.getSelectionModel().clearSelection();
                    limpiarCamposEmpleado();
                    mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no eliminado", "El empleado no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no seleccionado", "Seleccionado un empleado de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarEmpleado(){
        boolean empleadoActualizado = false;

        String cedulaActual = empleadoSeleccionado.cedula();
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        if(empleadoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(empleadoSeleccionado)){
                empleadoActualizado = empleadoControllerService.actualizarEmpleado(cedulaActual,empleadoDto);
                if(empleadoActualizado){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    listaEmpleadosDto.add(empleadoDto);
                    tbEmpleados.refresh();
                    mostrarMensaje("Notificación empleado", "Empleado actualizado", "El empleado se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEmpleado();
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no actualizado", "El empleado no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private EmpleadoDto construirEmpleadoDto() {
        return new EmpleadoDto(

                txtNombre.getText(),
                txtCedula.getText(),
                txtCorreo.getText(),
                txtCodigo.getText());
    }

    private void limpiarCamposEmpleado() {

        txtNombre.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");
        txtCodigo.setText("");
    }

    private boolean datosValidos(EmpleadoDto empleadoDto) {
        String mensaje = "";
        if (empleadoDto.nombre() == null || empleadoDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n";
        if (empleadoDto.cedula() == null || empleadoDto.cedula().equals(""))
            mensaje += "El codigo es invalido \n";
        if (empleadoDto.correo() == null || empleadoDto.correo().equals(""))
            mensaje += "El codigo es invalido \n";
        if (empleadoDto.evento() == null || empleadoDto.evento().equals(""))
            mensaje += "Los eventos asignados son invalidos \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


}
