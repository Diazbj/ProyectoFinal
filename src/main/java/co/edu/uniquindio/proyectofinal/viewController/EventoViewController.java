package co.edu.uniquindio.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.controller.EmpleadoController;
import co.edu.uniquindio.proyectofinal.controller.EventoController;
import co.edu.uniquindio.proyectofinal.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.mapping.dto.EventoDto;
import co.edu.uniquindio.proyectofinal.model.Reserva;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.Optional;

public class EventoViewController {

    EventoController eventoControllerService;
    ObservableList<EventoDto> listaEventosDto = FXCollections.observableArrayList();

    EventoDto eventoSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private ComboBox<EmpleadoDto> comboEmpleado;

    @FXML
    private TableView<EventoDto> tableEventos;

    @FXML
    private TableView<?> tableReservas;

    @FXML
    private TableColumn<EventoDto, String> tcCapacidad;

    @FXML
    private TableColumn<EventoDto, String> tcCodigo;

    @FXML
    private TableColumn<EventoDto, String> tcDescripcion;

    @FXML
    private TableColumn<EventoDto, String> tcEmpleado;

    @FXML
    private TableColumn<EventoDto, String> tcFecha;

    @FXML
    private TableColumn<EventoDto, String> tcNombre;

    @FXML
    private TableColumn<EventoDto, String> tcReservas;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private DatePicker txtFecha;

    @FXML
    private TextField txtNombre;



    @FXML
    void initialize(){
        eventoControllerService = new EventoController();
        initComboBox(); // Llamada a la función para inicializar el ComboBox
        initView();
    }
    StringConverter<EmpleadoDto> empleadoStringConverter = new StringConverter<EmpleadoDto>() {
        @Override
        public String toString(EmpleadoDto empleadoDto) {
            return empleadoDto.cedula();
        }

        @Override
        public EmpleadoDto fromString(String string) {
            // Este método no es necesario para la conversión de String a EmpleadoDto
            return null;
        }
    };

    private void initView() {
        initDataBinding();
        obtenerEventos();
        tableEventos.getItems().clear();
        tableEventos.setItems(listaEventosDto);
        listenerSelection();
    }

    void initComboBox() {
        ObservableList<EmpleadoDto> listaEmpleados = obtenerEmpleados();
        if (listaEmpleados != null) {
            comboEmpleado.setItems(listaEmpleados);
            comboEmpleado.setConverter(new StringConverter<>() {
                @Override
                public String toString(EmpleadoDto empleadoDto) {
                    // Verificar si el objeto EmpleadoDto es nulo antes de acceder a sus propiedades
                    if (empleadoDto != null) {
                        return empleadoDto.nombre() + " - " + empleadoDto.cedula();
                    } else {
                        return "";
                    }
                }

                @Override
                public EmpleadoDto fromString(String string) {
                    return null;
                }
            });
        } else {
            mostrarMensaje("Error", "No se pudieron obtener los empleados", "No se pudo cargar la lista de empleados", Alert.AlertType.ERROR);
        }
    }

    private void initDataBinding(){
        tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tcCapacidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().capacidadMax()));
        tcEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedulaEmpleado()));
        tcReservas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().reserva().getCodigo()));
    }

    private void obtenerEventos(){ listaEventosDto.addAll(eventoControllerService.obtenerEventos());}

    private ObservableList<EmpleadoDto> obtenerEmpleados() {
        EmpleadoController empleadoController = new EmpleadoController();
        return FXCollections.observableArrayList(empleadoController.obtenerEmpleados());
    }


    private void listenerSelection(){
        tableEventos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            eventoSeleccionado = newSelection;
            mostrarInformacionEvento(eventoSeleccionado);
        });
    }

    private void mostrarInformacionEvento(EventoDto eventoSeleccionado){
        if(eventoSeleccionado != null){
            txtCodigo.setText(eventoSeleccionado.codigo());
            txtNombre.setText(eventoSeleccionado.nombre());
            txtDescripcion.setText(eventoSeleccionado.descripcion());
            txtFecha.setValue(LocalDate.parse(eventoSeleccionado.fecha()));
            txtCapacidad.setText(eventoSeleccionado.capacidadMax());

            // Obtener la cédula del empleado asignado al evento seleccionado
            String cedulaEmpleado = eventoSeleccionado.cedulaEmpleado();

            // Buscar el EmpleadoDto correspondiente en la lista de empleados
            EmpleadoDto empleadoAsignado = null;
            for (EmpleadoDto empleadoDto : comboEmpleado.getItems()) {
                if (empleadoDto.cedula().equals(cedulaEmpleado)) {
                    empleadoAsignado = empleadoDto;
                    break;
                }
            }

            // Si se encontró el empleado, seleccionarlo en el ComboBox
            if (empleadoAsignado != null) {
                comboEmpleado.getSelectionModel().select(empleadoAsignado);
            } else {
                // Si el empleado no se encontró, limpiar la selección del ComboBox
                comboEmpleado.getSelectionModel().clearSelection();
            }
        }
    }


    @FXML
    void nuevoEventoAction(ActionEvent event) {
        txtCodigo.setText("Ingrese el codigo");
        txtNombre.setText("Ingrese el nombre");
        txtDescripcion.setText("Ingrese la Descripcion");
        txtFecha.setValue(null);
        txtCapacidad.setText("Ingrese la capacidad");
    }


    @FXML
    void agregarEventoAction(ActionEvent event) {
        crearEvento();
    }

    @FXML
    void eliminarEventoAction(ActionEvent event) {
        eliminarEvento();
    }

    @FXML
    void actualizarEventoAction(ActionEvent event) {
        actualizarEvento();
    }

    private void crearEvento(){
        EventoDto eventoDto = construirEventoDto();

        if(datosValidos(eventoDto)){
            if(eventoControllerService.agregarEvento(eventoDto)){
                listaEventosDto.add(eventoDto);
                mostrarMensaje("Notificacion Evento", "Evento creado", "El Evento se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEvento();
            }else{
                mostrarMensaje("Notificación Evento", "Evento no creado", "El Evento no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Evento", "Evento no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarEvento() {
        boolean eventoEliminado = false;
        if(eventoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar el evento?")){
                eventoEliminado = eventoControllerService.eliminarEvento(eventoSeleccionado.codigo());
                if(eventoEliminado == true){
                    listaEventosDto.remove(eventoSeleccionado);
                    eventoSeleccionado = null;
                    tableEventos.getSelectionModel().clearSelection();
                    limpiarCamposEvento();
                    mostrarMensaje("Notificación evento", "Evento eliminado", "El evento se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación evento", "Evento no eliminado", "El Evento no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación evento", "Evento no seleccionado", "Seleccionado un Evento de la lista", Alert.AlertType.WARNING);
        }
    }


    private void actualizarEvento(){
        boolean eventoActualizado = false;

        String idActual = eventoSeleccionado.codigo();
        EventoDto eventoDto = construirEventoDto();
        if(eventoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(eventoDto)){
                eventoActualizado = eventoControllerService.actualizarEvento(idActual,eventoDto);
                if(eventoActualizado){
                    listaEventosDto.remove(eventoSeleccionado);
                    listaEventosDto.add(eventoDto);
                    tableEventos.refresh();
                    mostrarMensaje("Notificación evento", "Evento actualizado", "El evento se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEvento();
                }else{
                    mostrarMensaje("Notificación evento", "Evento no actualizado", "El evento no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación evento", "Evento no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private EventoDto construirEventoDto() {
        String fecha = ""; // Inicializar la fecha como una cadena vacía
        LocalDate fechaSeleccionada = txtFecha.getValue(); // Obtener la fecha seleccionada del componente txtFecha
        if (fechaSeleccionada != null) {
            fecha = fechaSeleccionada.toString(); // Convertir la fecha seleccionada a una cadena
        }

        // Obtener el EmpleadoDto seleccionado del ComboBox
        EmpleadoDto empleadoDtoSeleccionado = comboEmpleado.getSelectionModel().getSelectedItem();

        return new EventoDto(
                txtCodigo.getText(),
                txtNombre.getText(),
                txtDescripcion.getText(),
                fecha,
                txtCapacidad.getText(),
                empleadoDtoSeleccionado != null ? empleadoDtoSeleccionado.cedula() : "", // Pasar el empleado seleccionado al constructor
                null); // Aquí puedes pasar la reserva si la obtienes de algún componente
    }


    private void limpiarCamposEvento() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtFecha.setValue(null);
        txtCapacidad.setText("");
        comboEmpleado.getSelectionModel().clearSelection();
    }

    private boolean datosValidos(EventoDto eventoDto) {
        String mensaje = "";
        if (eventoDto.nombre() == null || eventoDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n";
        if (eventoDto.codigo() == null || eventoDto.codigo().equals(""))
            mensaje += "El codigo es invalido \n";
        if (eventoDto.descripcion() == null || eventoDto.descripcion().equals(""))
            mensaje += "El correo es invalido \n";
        if (eventoDto.fecha() == null || eventoDto.fecha().equals(""))
            mensaje += "la fecha es invalida \n";
        if (eventoDto.capacidadMax() == null || eventoDto.capacidadMax().equals(""))
            mensaje += "la capacidad maxima es invalida \n";
        if (eventoDto.cedulaEmpleado() == null || eventoDto.cedulaEmpleado() == null || eventoDto.cedulaEmpleado().equals(""))
            mensaje += "los ID de los empleados son invalidos \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación Evento","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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
        return action.isPresent() && action.get() == ButtonType.OK;
    }

}
