package javafxapplication2.hayderService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxapplication2.hayderModel.Recruteur;

public class RecruiterService {

    private final ObservableList<Recruteur> recruiters = FXCollections.observableArrayList();

    public ObservableList<Recruteur> getAll() {
        return recruiters;
    }

    public void add(Recruteur r) {
        recruiters.add(r);
    }

    public void update(Recruteur updated) {
        for (int i = 0; i < recruiters.size(); i++) {
            if (recruiters.get(i).getId().equals(updated.getId())) {
                recruiters.set(i, updated);
                return;
            }
        }
    }

    public void delete(Recruteur r) {
        recruiters.remove(r);
    }
}
