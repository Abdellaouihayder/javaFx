package javafxapplication2.baraaController;

import javafxapplication2.hayderController.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import javafxapplication2.hayderService.CandidateService;
import javafxapplication2.baraaModel.Candidat;

import java.io.IOException;
import java.util.List;

public class CandidatesController {

    @FXML private TextField searchField;
    @FXML private Button BackBtn;
    @FXML private Button addBtn;
    @FXML private FlowPane candidatesFlow;

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;

    private CandidateService candidateService;

    @FXML
    public void initialize() {
        candidateService = new CandidateService();

        display(candidateService.getAll());

        BackBtn.setOnAction(this::Back);
        addBtn.setOnAction(e -> onAdd());

        searchField.textProperty().addListener((obs, oldVal, newVal) -> search());
    }

    private void display(List<Candidat> list) {
        candidatesFlow.getChildren().clear();

        for (Candidat c : list) {
            VBox card = new VBox();
            card.setSpacing(5);
            card.setPadding(new Insets(10));
            card.setStyle("-fx-background-color: white; -fx-background-radius: 8;");
            
            Label name = new Label(c.getNom() + " " + c.getPrenom());
            Label email = new Label(c.getEmail());
            Label phone = new Label(c.getTelephone());

            card.getChildren().addAll(name, email, phone);
            candidatesFlow.getChildren().add(card);
        }
    }

    private void search() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            display(candidateService.getAll());
        } else {
            display(candidateService.search(keyword));
        }
    }

    private void onAdd() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            showAlert("Error", "First name, last name and email are required!");
            return;
        }

        Candidat newCandidate = new Candidat();
        newCandidate.setNom(lastName);
        newCandidate.setPrenom(firstName);
        newCandidate.setEmail(email);
        newCandidate.setTelephone(phone);

        candidateService.addCandidate(newCandidate);

        display(candidateService.getAll());

        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void Back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/javafxapplication2/hayder/GUI/dashboard_admin.fxml"));
            Stage stage = (Stage) BackBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard Admin");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Impossible to navigate to dashboard");
        }
    }
}
