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

public class DashboardResponsableController {

    // ---------------- REAL NAVIGATION BUTTONS ---------------- //

    @FXML
    private void onLogout(ActionEvent event) {
        System.out.println("Logout clicked");
        navigateTo(event, "/javafxapplication2/hayder/GUI/home.fxml", "Home");
    }

    @FXML
    private void onNotifications(ActionEvent event) {
        System.out.println("Notifications clicked");
        navigateTo(event, "/javafxapplication2/hayder/GUI/notification.fxml", "Notifications");
    }

  @FXML
private void onProfile(ActionEvent event) {
    System.out.println("Profile clicked");
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxapplication2/hayder/GUI/profil.fxml"));
        Parent root = loader.load();

        // Pass origin info
        ProfileController controller = loader.getController();
        controller.setOriginDashboard("responsable");

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Profile");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    // ---------------- SIMPLE PRINT BUTTONS ---------------- //

    @FXML
    private void onDashboard(ActionEvent event) {
        System.out.println("Dashboard clicked");
    }

    @FXML
    private void onHome(ActionEvent event) {
        System.out.println("Home clicked");
    }

    @FXML
    private void onManageJobOffers(ActionEvent event) {
        System.out.println("Manage Job Offers clicked");
    }

    @FXML
    private void onViewCandidates(ActionEvent event) {
        System.out.println("View Candidates clicked");
    }

    @FXML
    private void onCompanyProfile(ActionEvent event) {
        System.out.println("Company Profile clicked");
    }

    @FXML
    private void onMessages(ActionEvent event) {
        System.out.println("Messages clicked");
    }

    // --------------------------------------------------------------- //
    // ✅ Utility method to load new FXML
    // --------------------------------------------------------------- //
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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
