package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField nomField, prenomField, emailField;

    @FXML
    private PasswordField passwordField, confirmPasswordField;

    @FXML
    private void initialize() {
        System.out.println("Register screen initialized!");
    }

    @FXML
    private void onSignUpClick() {
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String confirm = confirmPasswordField.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }
        if (!isValidEmail(email)) {
            showAlert("Erreur", "Adresse email invalide.");
            return;
        }
        if (!password.equals(confirm)) {
            showAlert("Erreur", "Les mots de passe ne correspondent pas.");
            return;
        }
        showAlert("Succès", "Compte créé avec succès !");
        navigateTo("/javafxapplication2/hayder/GUI/responsable_dashboard.fxml", "Dashboard");
    }

    @FXML
    private void onResetClick() {
        nomField.clear();
        prenomField.clear();
        emailField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
    }

    @FXML
    private void onBackToLoginClick() {
        navigateTo("/javafxapplication2/hayder/GUI/login.fxml", "Se Connecter");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$";
        return email.matches(emailRegex);
    }

    private void navigateTo(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) nomField.getScene().getWindow();
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
