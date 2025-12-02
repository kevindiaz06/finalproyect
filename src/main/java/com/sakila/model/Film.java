package com.sakila.model;

import javafx.beans.property.*;

/**
 * Clase modelo que representa una película en la base de datos Sakila.
 * Utiliza JavaFX Properties para permitir el binding automático con la interfaz de usuario.
 * 
 * @author Sistema Sakila
 * @version 1.0
 */
public class Film {
    
    // Propiedades JavaFX para binding con la UI
    private final IntegerProperty filmId;
    private final StringProperty title;
    private final StringProperty description;
    private final IntegerProperty releaseYear;
    private final IntegerProperty languageId;
    private final StringProperty rating;
    
    /**
     * Constructor completo con todos los campos.
     * 
     * @param filmId ID único de la película
     * @param title Título de la película
     * @param description Descripción argumental
     * @param releaseYear Año de lanzamiento
     * @param languageId ID del idioma (Foreign Key)
     * @param rating Clasificación de la película (G, PG, PG-13, R, NC-17)
     */
    public Film(int filmId, String title, String description, int releaseYear, int languageId, String rating) {
        this.filmId = new SimpleIntegerProperty(filmId);
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.releaseYear = new SimpleIntegerProperty(releaseYear);
        this.languageId = new SimpleIntegerProperty(languageId);
        this.rating = new SimpleStringProperty(rating);
    }
    
    /**
     * Constructor vacío para crear nuevas películas.
     */
    public Film() {
        this(0, "", "", 2024, 1, "G");
    }
    
    // ==================== Getters y Setters ====================
    
    // Film ID
    public int getFilmId() {
        return filmId.get();
    }
    
    public void setFilmId(int filmId) {
        this.filmId.set(filmId);
    }
    
    public IntegerProperty filmIdProperty() {
        return filmId;
    }
    
    // Title
    public String getTitle() {
        return title.get();
    }
    
    public void setTitle(String title) {
        this.title.set(title);
    }
    
    public StringProperty titleProperty() {
        return title;
    }
    
    // Description
    public String getDescription() {
        return description.get();
    }
    
    public void setDescription(String description) {
        this.description.set(description);
    }
    
    public StringProperty descriptionProperty() {
        return description;
    }
    
    // Release Year
    public int getReleaseYear() {
        return releaseYear.get();
    }
    
    public void setReleaseYear(int releaseYear) {
        this.releaseYear.set(releaseYear);
    }
    
    public IntegerProperty releaseYearProperty() {
        return releaseYear;
    }
    
    // Language ID
    public int getLanguageId() {
        return languageId.get();
    }
    
    public void setLanguageId(int languageId) {
        this.languageId.set(languageId);
    }
    
    public IntegerProperty languageIdProperty() {
        return languageId;
    }
    
    // Rating
    public String getRating() {
        return rating.get();
    }
    
    public void setRating(String rating) {
        this.rating.set(rating);
    }
    
    public StringProperty ratingProperty() {
        return rating;
    }
    
    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId.get() +
                ", title='" + title.get() + '\'' +
                ", releaseYear=" + releaseYear.get() +
                ", rating='" + rating.get() + '\'' +
                '}';
    }
}
