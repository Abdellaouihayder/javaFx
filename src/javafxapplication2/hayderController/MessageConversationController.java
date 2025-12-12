package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    // -------------------- BACK BUTTON --------------------
    @FXML
    private void Back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/javafxapplication2/hayder/GUI/responsable_dashboard.fxml"));
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
