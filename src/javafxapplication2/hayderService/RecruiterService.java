package javafxapplication2.hayderService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxapplication2.hayderModel.Recruteur;

import java.util.List;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    // 1. Find a recruiter by ID using streams
    public Optional<Recruteur> findById(String id) {
        return recruiters.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    // 2. Get a list of all recruiter names using streams
    public List<String> getAllNames() {
        return recruiters.stream()
                .map(Recruteur::getId) // assuming Recruteur has getName()
                .collect(Collectors.toList());
    }
}
