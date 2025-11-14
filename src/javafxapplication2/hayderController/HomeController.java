package javafxapplication2.hayderController;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private void handleLogin(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/login.fxml", "Se Connecter");
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/register.fxml", "Créer votre compte");
    }

    @FXML
    private void handleAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("À propos");
        alert.setHeaderText("Agence de Recrutement et Gestion d'Appels d’Offres");
        alert.setContentText("Version 1.0\nDéveloppé par Hayder Abdellaoui\n© 2025 Tous droits réservés.");
        alert.showAndWait();
    }

    // ✅ Utility method to load new FXML
    private void navigateTo(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible de charger la page : " + fxmlPath);
        }
    }

    // ✅ Reusable alert method
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
