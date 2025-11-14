package javafxapplication2.hayderModel;

import java.time.LocalDate;
import javafxapplication2.hayder.Exception.NotificationException;
import javafxapplication2.hayder.Interfaces.NotificationAction;

public record Notification(
        int id,
        LocalDate dateEnvoi,
        String contenu,
        String type
) implements NotificationAction {

    public void envoyer(Notification n) throws NotificationException {
        if (n.contenu().isEmpty()) {
            throw new NotificationException("Le contenu de la notification est vide !");
        }
        System.out.println("Notification envoyée : " + n.contenu());
    }
}
