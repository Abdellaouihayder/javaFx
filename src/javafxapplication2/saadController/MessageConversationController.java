package javafxapplication2.saadController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Contrôleur Messagerie - Partie Saad Eddine
 */
public class MessageConversationController {

    @FXML
    private ListView<String> messagesList;
    @FXML
    private TextField destinataireField;
    @FXML
    private TextField messageField;

    private ObservableList<String> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        messagesList.setItems(data);
    }
    @FXML
    private void envoyerMessage() {
        String dest = destinataireField.getText();
        String msg = messageField.getText();
        if (!msg.isEmpty() && !dest.isEmpty()) {
            data.add("À " + dest + " : " + msg);
            messageField.clear();
        }
    }
}