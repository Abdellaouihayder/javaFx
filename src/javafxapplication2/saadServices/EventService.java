package javafxapplication2.saadServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxapplication2.saadModel.EventModel;

public class EventService {

    // Renvoie une liste d’événements fictifs
    public ObservableList<EventModel> getFakeEvents() {
        ObservableList<EventModel> list = FXCollections.observableArrayList();

        list.add(new EventModel("09:00", "Réunion équipe"));
        list.add(new EventModel("11:00", "Appel client"));
        list.add(new EventModel("14:30", "Préparation dossier"));
        list.add(new EventModel("16:00", "Contrôle du planning"));

        return list;
    }
}
