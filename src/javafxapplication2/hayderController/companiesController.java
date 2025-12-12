package javafxapplication2.hayderController;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafxapplication2.hayderService.CompanyService;
import javafxapplication2.baraaModel.Entreprise;

import java.util.List;

public class companiesController {

    @FXML private TextField searchField;
    @FXML private TextField companyNameField;

    @FXML private Button BackBtn;
    @FXML private Button addBtn;
    @FXML private Button allDomainsBtn;

    @FXML private FlowPane companiesFlow;

    private CompanyService companyService;

    @FXML
    public void initialize() {
        companyService = new CompanyService();

        display(companyService.getAll());

        BackBtn.setOnAction(this::Back);
        addBtn.setOnAction(e -> onAdd());
        allDomainsBtn.setOnAction(e -> onAllDomains());

        searchField.textProperty().addListener((obs, oldVal, newVal) -> search());
    }

    private void display(List<Entreprise> list) {
        companiesFlow.getChildren().clear();

        for (Entreprise c : list) {
            VBox box = new VBox();
            box.setSpacing(5);
            box.setPadding(new Insets(10));
            box.getStyleClass().add("company-card");

            Label name = new Label(c.getNom());
            name.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

            box.getChildren().add(name);

            companiesFlow.getChildren().add(box);
        }
    }

    @FXML
    private void search() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            display(companyService.getAll());
        } else {
            display(companyService.search(keyword));
        }
    }

    @FXML
    private void onAdd() {
        String name = companyNameField.getText().trim();

        if (name.isEmpty()) {
            showAlert("Error", "Company name cannot be empty.");
            return;
        }

        Entreprise newCompany = new Entreprise(companyService.getAll().size() + 1, name);
        companyService.addCompany(newCompany);

        showAlert("Success", "Company added successfully!");

        companyNameField.clear();
        display(companyService.getAll());
    }

    @FXML
    private void onAllDomains() {
        showAlert("Info", "All domains feature coming soon!");
    }

    private void navigateTo(ActionEvent event, String fxmlPath, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Cannot navigate to " + title);
        }
    }

    @FXML
    private void Back(ActionEvent event) {
        navigateTo(event, "/javafxapplication2/hayder/GUI/dashboard_admin.fxml", "Dashboard Admin");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
