
package javafxapplication2.hayder.Interfaces;
import javafxapplication2.hayder.Exception.NotificationException;
import javafxapplication2.hayderModel.Notification;

public interface NotificationAction {
    void envoyer(Notification n) throws NotificationException;
}
