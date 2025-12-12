package javafxapplication2.baraaController;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafxapplication2.baraaModel.Offre;
import javafxapplication2.baraaServices.OffreService;

import java.util.List;

public class JobOffersController {

    @FXML private TextField searchField;
    @FXML private Button searchBtn;
    @FXML private Button addBtn;
    @FXML private FlowPane offersFlow;

    private OffreService offreService;

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
    }

    private void search() {
        String keyword = searchField.getText().trim();
        List<Offre> result = offreService.search(keyword);
        display(result);
    }

    private void handleAddOffer() {
        System.out.println("TODO: Open add-offer popup");
        // You can later implement a dialog to input new offer
        // Example: offreService.addOffre(new Offre(...)); then refresh
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
}
