package javafxapplication2.saadModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Modèle d'événement minimal pour le calendrier - Partie Saad Eddine
 */
public class EventModel {
    private final StringProperty heure;
    private final StringProperty description;

    public EventModel(String heure, String description) {
        this.heure = new SimpleStringProperty(heure);
        this.description = new SimpleStringProperty(description);
    }

    public StringProperty heureProperty() { return heure; }
    public StringProperty descriptionProperty() { return description; }
    public String getHeure() { return heure.get(); }
    public String getDescription() { return description.get(); }
    public void setHeure(String h) { heure.set(h); }
    public void setDescription(String d) { description.set(d); }
}