package javafxapplication2.saadModel;

import java.time.LocalDateTime;

/**
 * Classe Date personnalisée — Partie développée par Saad Eddine
 */
public class SEDate {
    private LocalDateTime dateTime;

    public SEDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}