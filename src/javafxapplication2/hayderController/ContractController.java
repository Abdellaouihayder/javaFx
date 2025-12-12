package javafxapplication2.hayderController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafxapplication2.saadModel.Contract;
import javafxapplication2.saadModel.SEDate;

public class ContractController {

    @FXML
    private TextField clientNameField;
    @FXML
    private ComboBox<String> contractTypeBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField salaryField;

    @FXML
    private Button validateButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button BackButton;

    // TableView
    @FXML
    private TableView<Contract> contractTable;
    @FXML
    private TableColumn<Contract, String> nameColumn;
    @FXML
    private TableColumn<Contract, String> typeColumn;
    @FXML
    private TableColumn<Contract, String> startColumn;
    @FXML
    private TableColumn<Contract, String> endColumn;
    @FXML
    private TableColumn<Contract, String> salaryColumn;

    private ObservableList<Contract> contractList = FXCollections.observableArrayList();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    public void initialize() {

        // ComboBox types
        contractTypeBox.getItems().addAll("CDI", "CDD", "Stage", "Freelance", "Temps partiel");

        // Config TableView
        nameColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getClientName()));
        typeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTypeContract()));
        startColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDateDebut().getDateTime().toLocalDate().format(dtf)));
        endColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDateFin().getDateTime().toLocalDate().format(dtf)));
        salaryColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(String.valueOf(data.getValue().getSalaire())));

        contractTable.setItems(contractList);
    }

    @FXML
    private void validerContract(ActionEvent event) {

        if (clientNameField.getText().isEmpty()
                || contractTypeBox.getValue() == null
                || startDatePicker.getValue() == null
                || endDatePicker.getValue() == null
                || salaryField.getText().isEmpty()) {

            showAlert(AlertType.ERROR, "Champs manquants", "Veuillez remplir tous les champs.");
            return;
        }

        float salaire;
        try {
            salaire = Float.parseFloat(salaryField.getText());
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Salaire invalide", "Veuillez entrer un nombre valide.");
            return;
        }

        SEDate dateDebut = new SEDate(startDatePicker.getValue().atStartOfDay());
        SEDate dateFin = new SEDate(endDatePicker.getValue().atStartOfDay());

        Contract c = new Contract(
                0, // idContract (ou 0 pour auto)
                clientNameField.getText(), // <-- NOM DU CLIENT
                contractTypeBox.getValue(), // type de contrat
                dateDebut, // date début
                dateFin, // date fin
                salaire // salaire
        );

        contractList.add(c);

        showAlert(AlertType.INFORMATION, "Succès", "Contrat ajouté pour : " + clientNameField.getText());

        // Vider formulaire
        cancelContract(null);
    }

    @FXML
    private void cancelContract(ActionEvent event) {
        clientNameField.clear();
        contractTypeBox.setValue(null);
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        salaryField.clear();
    }

    @FXML
    private void BackToDashboard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/javafxapplication2/hayder/GUI/responsable_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Erreur", "Impossible de charger la page home.fxml");
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
