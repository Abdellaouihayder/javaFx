package javafxapplication2.hayderController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafxapplication2.baraaModel.Entreprise;

import java.util.List;

public class EntrepriseController {

    @FXML private TableView<Entreprise> entrepriseTable;
    @FXML private TableColumn<Entreprise, Integer> idColumn;
    @FXML private TableColumn<Entreprise, String> nameColumn;
    @FXML private TableColumn<Entreprise, String> adresseColumn;
    @FXML private TableColumn<Entreprise, String> secteurColumn;
    @FXML private TableColumn<Entreprise, Long> offresColumn;
    @FXML private TableColumn<Entreprise, Long> postulationsColumn;

    private ObservableList<Entreprise> entrepriseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Config colonnes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        secteurColumn.setCellValueFactory(new PropertyValueFactory<>("secteur"));
        offresColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleLongProperty(cellData.getValue().getOffres().size()).asObject()
        );
        postulationsColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleLongProperty(cellData.getValue().compterPostulationsTotales()).asObject()
        );

        // Exemple de données (ou récupérer depuis ton service)
        entrepriseList.addAll(getFakeEntreprises());
        entrepriseTable.setItems(entrepriseList);
    }

    // ---------------- BACK ---------------- //
    @FXML
    private void BackToDashboard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/javafxapplication2/hayder/GUI/responsable_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- FAKE DATA ---------------- //
    private List<Entreprise> getFakeEntreprises() {
        Entreprise e1 = new Entreprise(1, "MediaCorp", "Tunis", "Media");
        Entreprise e2 = new Entreprise(2, "TechSolutions", "Sfax", "IT");
        Entreprise e3 = new Entreprise(3, "Foodies", "Sousse", "Restauration");

        e1.ajouterOffre(new javafxapplication2.baraaModel.Offre());
        e2.ajouterOffre(new javafxapplication2.baraaModel.Offre());
        e2.ajouterOffre(new javafxapplication2.baraaModel.Offre());

        return List.of(e1, e2, e3);
    }
}
