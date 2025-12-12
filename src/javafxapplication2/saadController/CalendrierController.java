package javafxapplication2.saadController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafxapplication2.saadModel.EventModel;
import javafxapplication2.saadServices.EventService;


public class CalendrierController {

    @FXML private DatePicker datePicker;
    @FXML private TableView<EventModel> eventTable;
    @FXML private TableColumn<EventModel, String> heureColumn;
    @FXML private TableColumn<EventModel, String> descColumn;
    @FXML private TableColumn<EventModel, Void> actionsColumn;
    @FXML private TextField eventField;

    // Liste observable
    private ObservableList<EventModel> events = FXCollections.observableArrayList();

    // Service
    private EventService eventService = new EventService();

    @FXML
    public void initialize() {

        // Charger les FAKE DATA depuis le service
        events.addAll(eventService.getFakeEvents());

        // Init colonnes
        heureColumn.setCellValueFactory(new PropertyValueFactory<>("heure"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        actionsColumn.setCellFactory(getActionsCellFactory());

        eventTable.setItems(events);
    }

    @FXML
    private void ajouterEvenement() {
        String eventDesc = eventField.getText();
        String heure = "08:00";

        if (!eventDesc.isEmpty() && datePicker.getValue() != null) {
            events.add(new EventModel(heure, eventDesc));
            eventField.clear();
        }
    }

    private Callback<TableColumn<EventModel, Void>, TableCell<EventModel, Void>> getActionsCellFactory() {
        return param -> new TableCell<EventModel, Void>() {
            private final Button deleteBtn = new Button("Supprimer");

            {
                deleteBtn.setStyle("-fx-background-color: #e53935; -fx-text-fill: white; -fx-background-radius: 6;");
                deleteBtn.setOnAction((ActionEvent event) -> {
                    EventModel ev = getTableView().getItems().get(getIndex());
                    events.remove(ev);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : deleteBtn);
            }
        };
    }
}
