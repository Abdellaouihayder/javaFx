package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.regex.Pattern;

public class LoginController {

    @FXML
    private ImageView logoImage;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private final Pattern emailPattern = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    @FXML
    private void initialize() {
        System.out.println("Login interface initialized!");
    }

    @FXML
    private void onLoginButtonClick(ActionEvent event) {
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        // Validate email format
        if (!isValidEmail(email)) {
            showAlert("Erreur", "Veuillez entrer une adresse email valide.");
            return;
        }

        // Check password (simplified)
        if (!password.equals("1234")) {
            showAlert("Erreur", "Mot de passe incorrect.");
            return;
        }

        // Redirect based on email
        if (email.equalsIgnoreCase("admin@gmail.com")) {
            loadScene(event, "/javafxapplication2/hayder/GUI/dashboard_admin.fxml");
        } else {
            loadScene(event, "/javafxapplication2/hayder/GUI/responsable_dashboard.fxml");
        }
    }

    @FXML
    private void onResetButtonClick() {
        emailField.clear();
        passwordField.clear();
    }

    @FXML
    private void onForgotPasswordClick(ActionEvent event) {
        loadScene(event, "/javafxapplication2/hayder/GUI/forgot_password.fxml");
    }

    @FXML
    private void onCreateAccountClick(ActionEvent event) {
        loadScene(event, "/javafxapplication2/hayder/GUI/register.fxml");
    }

    private boolean isValidEmail(String email) {
        return emailPattern.matcher(email).find();
    }

    private void loadScene(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible de charger la page : " + fxmlPath);
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
