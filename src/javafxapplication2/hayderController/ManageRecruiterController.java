package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafxapplication2.hayderModel.Recruteur;
import javafxapplication2.hayderService.RecruiterService;
import java.io.IOException;

public class ManageRecruiterController {

    // ---------------- TABLE & FORM ----------------
    @FXML private TableView<Recruteur> tableRecruiters;
    @FXML private TableColumn<Recruteur, String> colId, colNom, colPrenom, colEmail, colPoste, colDomaine;

    @FXML private TextField txtId, txtNom, txtPrenom, txtEmail, txtPassword, txtPoste, txtDomaine;

    private final RecruiterService service = new RecruiterService();

    // ---------------- INITIALIZATION ----------------
    @FXML
    public void initialize() {
        // Table columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPoste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        colDomaine.setCellValueFactory(new PropertyValueFactory<>("domaineDeTravail"));

        // Fake data
        service.add(new Recruteur("R001", "Hayder", "Abdellaoui", "hayder@mail.com", "1234", "HR Manager", "Informatique"));
        service.add(new Recruteur("R002", "Sami", "Ben Ali", "sami@mail.com", "abcd", "Tech Recruiter", "Développement"));
        service.add(new Recruteur("R003", "Malek", "Trabelsi", "malek@mail.com", "pass", "Talent Acquisition", "Marketing"));

        tableRecruiters.setItems(service.getAll());
    }

    // -------------------- ADD RECRUITER ----------------
    @FXML
    private void addRecruiter() {
        if (!allFieldsFilled()) {
            showAlert("Erreur", "Veuillez remplir tous les champs !");
            return;
        }
        Recruteur r = new Recruteur(
                txtId.getText(), txtNom.getText(), txtPrenom.getText(),
                txtEmail.getText(), txtPassword.getText(),
                txtPoste.getText(), txtDomaine.getText()
        );
        service.add(r);
        tableRecruiters.setItems(service.getAll());
        clearFields();
    }

    // -------------------- UPDATE RECRUITER ----------------
    @FXML
    private void updateRecruiter() {
        Recruteur selected = tableRecruiters.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Erreur", "Veuillez sélectionner un recruteur !");
            return;
        }
        if (!allFieldsFilled()) {
            showAlert("Erreur", "Veuillez remplir tous les champs !");
            return;
        }
        Recruteur updated = new Recruteur(
                txtId.getText(), txtNom.getText(), txtPrenom.getText(),
                txtEmail.getText(), txtPassword.getText(),
                txtPoste.getText(), txtDomaine.getText()
        );
        service.update(updated);
        tableRecruiters.setItems(service.getAll());
        clearFields();
    }

    // -------------------- DELETE RECRUITER ----------------
    @FXML
    private void deleteRecruiter() {
        Recruteur selected = tableRecruiters.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Erreur", "Veuillez sélectionner un recruteur !");
            return;
        }
        service.delete(selected);
        tableRecruiters.setItems(service.getAll());
    }

    // -------------------- FORM HELPERS ----------------
    private void clearFields() {
        txtId.clear();
        txtNom.clear();
        txtPrenom.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtPoste.clear();
        txtDomaine.clear();
    }

    private boolean allFieldsFilled() {
        return !txtId.getText().isEmpty() &&
               !txtNom.getText().isEmpty() &&
               !txtPrenom.getText().isEmpty() &&
               !txtEmail.getText().isEmpty() &&
               !txtPassword.getText().isEmpty() &&
               !txtPoste.getText().isEmpty() &&
               !txtDomaine.getText().isEmpty();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // -------------------- NAVIGATION BUTTONS ----------------

    @FXML
    private void onLogout(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/home.fxml", "Home");
    }

    @FXML
    private void onDashboard(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/dashboard_admin.fxml", "Dashboard");
    }

    @FXML
    private void onNotifications(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/notification.fxml", "Notifications","admin");
    }

    @FXML
    private void onProfile(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxapplication2/hayder/GUI/profil.fxml"));
            Parent root = loader.load();

            ProfileController controller = loader.getController();
            controller.setOriginDashboard("admin");

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible de charger le profil");
        }
    }

    @FXML
    private void onHome(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/dashboard_admin.fxml", "Home");
    }

    @FXML
    private void onManageRecruiter(ActionEvent event) {
        // Already on this page, do nothing or refresh
        System.out.println("Manage Recruiter clicked (current page)");
    }

    @FXML
    private void onManageCompanies(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/companies.fxml", "Manage Companies");
    }

    @FXML
    private void onJobs(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/job.fxml", "Manage offres", "admin");
    }

    @FXML
    private void onManageCandidates(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/candidates.fxml", "Manage Candidates");
    }
     @FXML
    private void onManageDomains(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/domains.fxml", "domains");
    }
    // -------------------- NAVIGATION HELPER ----------------
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
 
}
