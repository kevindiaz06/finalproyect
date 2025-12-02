package com.sakila;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación JavaFX para el sistema de gestión Sakila.
 * Esta clase extiende Application y configura la ventana principal de la aplicación.
 * 
 * @author Sistema Sakila
 * @version 1.0
 */
public class SakilaApp extends Application {

    /**
     * Método principal de inicio de la aplicación JavaFX.
     * Configura la escena principal cargando el archivo FXML y aplicando estilos CSS.
     * 
     * @param primaryStage La ventana principal de la aplicación
     * @throws Exception Si hay errores al cargar los recursos FXML o CSS
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML de la vista principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FilmView.fxml"));
        Parent root = loader.load();
        
        // Crear la escena con dimensiones especificadas
        Scene scene = new Scene(root, 1200, 800);
        
        // Aplicar la hoja de estilos CSS para diseño moderno
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        
        // Configurar la ventana principal
        primaryStage.setTitle("Sistema de Gestión Sakila - Películas");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(600);
        
        // Mostrar la ventana
        primaryStage.show();
    }

    /**
     * Método main que lanza la aplicación JavaFX.
     * 
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}
