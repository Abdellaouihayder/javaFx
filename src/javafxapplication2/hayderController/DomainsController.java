package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;

import javafxapplication2.baraaModel.Domain;
import javafxapplication2.hayderService.DomainService;

import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DomainsController {

    @FXML
    private TextField searchField;
    @FXML
    private FlowPane domainsFlow;

    @FXML
    private VBox addFormPane;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea descField;

    private DomainService service;

    @FXML
    public void initialize() {
        service = new DomainService();

        loadDomains(service.getAll());

        // Hide the form initially
        addFormPane.setVisible(true);   // You want it visible
        addFormPane.setManaged(true);

        // Search listener
        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            loadDomains(service.search(newVal));
        });
    }

    private void loadDomains(List<Domain> list) {
        domainsFlow.getChildren().clear();

        for (Domain d : list) {

            VBox card = new VBox(5);
            card.getStyleClass().add("card");

            card.getChildren().addAll(
                    new Label("Name: " + d.getNom()),
                    new Label("Description: " + d.getDescription())
            );

            domainsFlow.getChildren().add(card);
        }
    }

    // Save Domain
    @FXML
    private void addDomain() {
        String name = nameField.getText().trim();
        String desc = descField.getText().trim();

        if (name.isEmpty()) {
            showAlert("Error", "Domain name is required!");
            return;
        }

        Domain d = new Domain(service.getAll().size() + 1, name, desc);
        service.getAll().add(d);

        loadDomains(service.getAll());
        clearForm();

        showAlert("Success", "Domain added successfully!");
    }

    // Clear / Cancel
    @FXML
    private void hideAddForm() {
        clearForm();
    }

    private void clearForm() {
        nameField.clear();
        descField.clear();
    }

    // Alert helper
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void Back() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxapplication2/hayder/GUI/dashboard_admin.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) searchField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error navigating to admin dashboard: " + e.getMessage());
        }
    }

}
