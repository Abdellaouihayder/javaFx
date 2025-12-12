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
    private void onCalendier(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/calendrier.fxml", "Calendier");
    }
    @FXML
    private void onNotifications(ActionEvent event) {
        System.out.println("Notifications clicked");
        // Passe "responsable" comme previousPage pour NotificationController
        navigateTo(event, "/javafxapplication2/hayder/GUI/notification.fxml", "Notifications", "responsable");
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

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        //System.out.println("Manage Job Offers clicked");
        navigateTo(event, "/javafxapplication2/hayder/GUI/job.fxml", "job_offers_dashboard", "responsable");
    }

    @FXML
    private void onContract(ActionEvent event) {
         navigateTo(event, "/javafxapplication2/hayder/GUI/contract.fxml", "Contacts Managment");
    }

    @FXML
    private void onCompanyProfile(ActionEvent event) {
         navigateTo(event, "/javafxapplication2/hayder/GUI/Entreprises.fxml", "Entreprises List");
    }

    @FXML
    private void onMessages(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/message_conversation.fxml", "Send Message");
    }

    // --------------------------------------------------------------- //
    // ✅ Modified navigateTo() with optional previousPage
    // --------------------------------------------------------------- //
    private void navigateTo(ActionEvent event, String fxmlPath, String title) {
        navigateTo(event, fxmlPath, title, null);
    }

    private void navigateTo(ActionEvent event, String fxmlPath, String title, String role) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // 🔥 Pass role to JobOffersController
            if (fxmlPath.contains("job.fxml") && role != null) {
                javafxapplication2.hayderController.JobOffersController controller = loader.getController();
                controller.setUserRole(role);
            }

            // 🔥 Already working: pass role only for notification page
            if (fxmlPath.contains("notification.fxml") && role != null) {
                javafxapplication2.hayderController.NotificationController controller = loader.getController();
                controller.setPreviousPage(role);
            }

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
