package com.sakila.controller;

import com.sakila.model.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controlador JavaFX para la gestión de películas.
 * Maneja la interacción entre la vista (FXML) y el modelo de datos.
 * Este controlador está preparado para integrarse con la capa de persistencia (gestor ORM).
 * 
 * @author Sistema Sakila
 * @version 1.0
 */
public class FilmController {
    
    // ==================== Componentes de la Tabla ====================
    @FXML
    private TableView<Film> filmTable;
    
    @FXML
    private TableColumn<Film, Integer> colId;
    
    @FXML
    private TableColumn<Film, String> colTitle;
    
    @FXML
    private TableColumn<Film, Integer> colYear;
    
    @FXML
    private TableColumn<Film, String> colRating;
    
    // ==================== Componentes del Formulario ====================
    @FXML
    private TextField txtTitle;
    
    @FXML
    private TextArea txtDescription;
    
    @FXML
    private TextField txtYear;
    
    @FXML
    private ComboBox<String> cmbLanguage;
    
    @FXML
    private ComboBox<String> cmbRating;
    
    // ==================== Botones de Acción ====================
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnSave;
    
    @FXML
    private Button btnUpdate;
    
    @FXML
    private Button btnDelete;
    
    // ==================== Datos ====================
    private ObservableList<Film> filmList = FXCollections.observableArrayList();
    private Film selectedFilm;
    
    /**
     * Método de inicialización automática de JavaFX.
     * Se ejecuta después de cargar el archivo FXML.
     */
    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla
        configureTableColumns();
        
        // Configurar los ComboBox
        configureComboBoxes();
        
        // Cargar datos de ejemplo (esto se reemplazará con datos reales de la BD)
        loadSampleData();
        
        // Configurar listeners para la selección de la tabla
        configureTableSelection();
    }
    
    /**
     * Configura las columnas de la tabla vinculándolas con las propiedades del modelo Film.
     */
    private void configureTableColumns() {
        colId.setCellValueFactory(new PropertyValueFactory<>("filmId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        colRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        
        filmTable.setItems(filmList);
    }
    
    /**
     * Configura los ComboBox con opciones predefinidas.
     */
    private void configureComboBoxes() {
        // Idiomas disponibles (simulando Foreign Key)
        cmbLanguage.setItems(FXCollections.observableArrayList(
            "Inglés", "Español", "Francés", "Alemán", "Italiano", "Japonés"
        ));
        cmbLanguage.setValue("Inglés");
        
        // Clasificaciones de películas
        cmbRating.setItems(FXCollections.observableArrayList(
            "G", "PG", "PG-13", "R", "NC-17"
        ));
        cmbRating.setValue("G");
    }
    
    /**
     * Carga datos de ejemplo para demostración.
     * TODO: Reemplazar con consulta real a la base de datos Sakila usando el gestor ORM.
     */
    private void loadSampleData() {
        filmList.add(new Film(1, "El Padrino", "Drama sobre una familia mafiosa", 1972, 1, "R"));
        filmList.add(new Film(2, "Pulp Fiction", "Crimen y violencia en Los Ángeles", 1994, 1, "R"));
        filmList.add(new Film(3, "Forrest Gump", "La vida extraordinaria de un hombre simple", 1994, 1, "PG-13"));
        filmList.add(new Film(4, "Matrix", "Realidad virtual y filosofía ciberpunk", 1999, 1, "R"));
        filmList.add(new Film(5, "El Rey León", "Aventuras de un joven león", 1994, 1, "G"));
    }
    
    /**
     * Configura el listener para la selección de filas en la tabla.
     * Cuando se selecciona una película, sus datos se cargan en el formulario.
     */
    private void configureTableSelection() {
        filmTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    selectedFilm = newValue;
                    loadFilmToForm(newValue);
                }
            }
        );
    }
    
    /**
     * Carga los datos de una película en el formulario.
     * 
     * @param film La película a cargar
     */
    private void loadFilmToForm(Film film) {
        txtTitle.setText(film.getTitle());
        txtDescription.setText(film.getDescription());
        txtYear.setText(String.valueOf(film.getReleaseYear()));
        cmbRating.setValue(film.getRating());
    }
    
    /**
     * Limpia todos los campos del formulario.
     */
    private void clearForm() {
        txtTitle.clear();
        txtDescription.clear();
        txtYear.clear();
        cmbLanguage.setValue("Inglés");
        cmbRating.setValue("G");
        filmTable.getSelectionModel().clearSelection();
        selectedFilm = null;
    }
    
    // ==================== Event Handlers ====================
    
    /**
     * Maneja el evento del botón "Nuevo".
     * Limpia el formulario para crear una nueva película.
     */
    @FXML
    private void handleNew() {
        clearForm();
        showInfo("Nuevo Registro", "Complete el formulario para crear una nueva película.");
    }
    
    /**
     * Maneja el evento del botón "Guardar".
     * Crea una nueva película con los datos del formulario.
     * TODO: Integrar con el gestor ORM para persistir en la base de datos.
     */
    @FXML
    private void handleSave() {
        if (validateForm()) {
            // Crear nueva película
            Film newFilm = new Film();
            newFilm.setFilmId(filmList.size() + 1); // Auto-incremento simulado
            newFilm.setTitle(txtTitle.getText());
            newFilm.setDescription(txtDescription.getText());
            newFilm.setReleaseYear(Integer.parseInt(txtYear.getText()));
            newFilm.setLanguageId(cmbLanguage.getSelectionModel().getSelectedIndex() + 1);
            newFilm.setRating(cmbRating.getValue());
            
            // Añadir a la lista (en producción, guardar en BD)
            filmList.add(newFilm);
            
            clearForm();
            showSuccess("Guardado", "La película se ha guardado correctamente.");
        }
    }
    
    /**
     * Maneja el evento del botón "Actualizar".
     * Actualiza los datos de la película seleccionada.
     * TODO: Integrar con el gestor ORM para actualizar en la base de datos.
     */
    @FXML
    private void handleUpdate() {
        if (selectedFilm == null) {
            showWarning("Advertencia", "Seleccione una película para actualizar.");
            return;
        }
        
        if (validateForm()) {
            // Actualizar datos
            selectedFilm.setTitle(txtTitle.getText());
            selectedFilm.setDescription(txtDescription.getText());
            selectedFilm.setReleaseYear(Integer.parseInt(txtYear.getText()));
            selectedFilm.setLanguageId(cmbLanguage.getSelectionModel().getSelectedIndex() + 1);
            selectedFilm.setRating(cmbRating.getValue());
            
            // Refrescar tabla
            filmTable.refresh();
            
            showSuccess("Actualizado", "La película se ha actualizado correctamente.");
        }
    }
    
    /**
     * Maneja el evento del botón "Eliminar".
     * Marca la película como inactiva (soft delete).
     * TODO: Integrar con el gestor ORM para marcar como inactiva en la base de datos.
     */
    @FXML
    private void handleDelete() {
        if (selectedFilm == null) {
            showWarning("Advertencia", "Seleccione una película para eliminar.");
            return;
        }
        
        // Confirmar eliminación
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Confirmar Eliminación");
        confirmDialog.setHeaderText("¿Está seguro de marcar esta película como inactiva?");
        confirmDialog.setContentText("Película: " + selectedFilm.getTitle());
        
        confirmDialog.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Eliminar de la lista (en producción, marcar como inactiva en BD)
                filmList.remove(selectedFilm);
                clearForm();
                showSuccess("Eliminado", "La película se ha marcado como inactiva.");
            }
        });
    }
    
    // ==================== Validación ====================
    
    /**
     * Valida los datos del formulario antes de guardar/actualizar.
     * 
     * @return true si todos los campos son válidos, false en caso contrario
     */
    private boolean validateForm() {
        String errors = "";
        
        if (txtTitle.getText().trim().isEmpty()) {
            errors += "- El título es obligatorio.\n";
        }
        
        if (txtYear.getText().trim().isEmpty()) {
            errors += "- El año de lanzamiento es obligatorio.\n";
        } else {
            try {
                int year = Integer.parseInt(txtYear.getText());
                if (year < 1888 || year > 2100) {
                    errors += "- El año debe estar entre 1888 y 2100.\n";
                }
            } catch (NumberFormatException e) {
                errors += "- El año debe ser un número válido.\n";
            }
        }
        
        if (!errors.isEmpty()) {
            showError("Errores de Validación", errors);
            return false;
        }
        
        return true;
    }
    
    // ==================== Utilidades para Diálogos ====================
    
    private void showInfo(String title, String message) {
        showAlert(Alert.AlertType.INFORMATION, title, message);
    }
    
    private void showSuccess(String title, String message) {
        showAlert(Alert.AlertType.INFORMATION, title, message);
    }
    
    private void showWarning(String title, String message) {
        showAlert(Alert.AlertType.WARNING, title, message);
    }
    
    private void showError(String title, String message) {
        showAlert(Alert.AlertType.ERROR, title, message);
    }
    
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
