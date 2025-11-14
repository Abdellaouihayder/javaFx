package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class ForgotPasswordController {

    @FXML
    private TextField emailField;

    // Simple email regex pattern
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    @FXML
    private void initialize() {
        System.out.println("Forgot Password screen initialized!");
    }

    @FXML
    private void onSendClick() {
        String email = emailField.getText().trim();

        if (email.isEmpty()) {
            showAlert("Erreur", "Veuillez entrer votre adresse email.");
            return;
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            showAlert("Erreur", "Veuillez entrer une adresse email valide.");
            return;
        }

        // If valid, show success message
        showAlert("Succès", "Lien de récupération envoyé à " + email + " !");
    }

    @FXML
    private void onBackToLoginClick() {
        navigateTo("/javafxapplication2/hayder/GUI/login.fxml", "Se Connecter");
    }

    private void navigateTo(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
