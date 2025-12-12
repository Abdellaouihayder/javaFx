package javafxapplication2.hayderController;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafxapplication2.baraaModel.Offre;

import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafxapplication2.hayderService.OffreService;

public class JobOffersController {

    @FXML private TextField searchField;
    @FXML private Button searchBtn;
    @FXML private Button addBtn, backBtn;
    @FXML private FlowPane offersFlow;

    private OffreService offreService;

    // 🔥 Nouvelle variable pour savoir qui a ouvert cette page
    private String userRole; // "admin" ou "responsable"

    public void setUserRole(String role) {
        this.userRole = role;
    }

    @FXML
    public void initialize() {
        offreService = new OffreService();

        // Load all offers
        display(offreService.getAll());

        // Search button
        searchBtn.setOnAction(e -> search());

        // Live search
        searchField.textProperty().addListener((obs, oldVal, newVal) -> search());

        // Add button
        addBtn.setOnAction(e -> handleAddOffer());

        // Back button navigation
        backBtn.setOnAction(e -> navigateBackToDashboard());
    }

    private void search() {
        String keyword = searchField.getText().trim();
        List<Offre> result = offreService.search(keyword);
        display(result);
    }

    private void handleAddOffer() {
        System.out.println("TODO: Open add-offer popup");
    }

    private void display(List<Offre> list) {
        offersFlow.getChildren().clear();
        for (Offre o : list) {
            VBox box = new VBox();
            box.setSpacing(5);
            box.setPadding(new Insets(10));
            box.setStyle("-fx-background-color: white; -fx-background-radius: 8;");

            box.getChildren().add(new Label(o.getTitre()));
            box.getChildren().add(new Label(o.getEntreprise() != null ? o.getEntreprise().getNom() : "No company"));
            box.getChildren().add(new Label(o.getLocalisation()));
            box.getChildren().add(new Label("Salary: " + o.getSalaire()));

            box.setOnMouseClicked(e -> System.out.println("Clicked offer ID = " + o.getId()));

            offersFlow.getChildren().add(box);
        }
    }

    // 🔥 Navigation intelligente selon le role
    private void navigateBackToDashboard() {
        try {
            String fxml;

            if ("admin".equals(userRole)) {
                fxml = "/javafxapplication2/hayder/GUI/dashboard_admin.fxml";
            } else if ("responsable".equals(userRole)) {
                fxml = "/javafxapplication2/hayder/GUI/responsable_dashboard.fxml";
            } else {
                showAlert("Erreur", "Impossible de déterminer le rôle de l'utilisateur !");
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            Stage stage = (Stage) backBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible de charger la page Dashboard");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
