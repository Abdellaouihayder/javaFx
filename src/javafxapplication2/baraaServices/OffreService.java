package javafxapplication2.baraaServices;

import javafxapplication2.baraaModel.Domain;
import javafxapplication2.baraaModel.Entreprise;
import javafxapplication2.baraaModel.Offre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OffreService {

    private List<Offre> offres;

    public OffreService() {
        offres = new ArrayList<>();
        loadDummyData(); // Fill some sample offers
    }

    // Returns all job offers
    public List<Offre> getAll() {
        return new ArrayList<>(offres);
    }

    // Search offers by keyword in title or localisation
    public List<Offre> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAll();
        }
        String lower = keyword.toLowerCase();
        return offres.stream()
                .filter(o -> o.getTitre().toLowerCase().contains(lower)
                          || o.getLocalisation().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    // Add new offer
    public void addOffre(Offre offre) {
        if (offre != null) {
            offres.add(offre);
        }
    }

    // Sample dummy data for testing
    private void loadDummyData() {
        Entreprise google = new Entreprise(1, "Google");
        Entreprise amazon = new Entreprise(2, "Amazon");

        Domain it = new Domain(1, "IT Development", "Software development jobs");

        offres.add(new Offre(1, "Full Stack Developer", "Develop web apps", "CDI", 5000, "Remote", new Date()));
        offres.get(0).setEntreprise(google);
        offres.get(0).setDomain(it);

        offres.add(new Offre(2, "Java Backend Developer", "Work on backend APIs", "CDI", 4500, "Paris", new Date()));
        offres.get(1).setEntreprise(amazon);
        offres.get(1).setDomain(it);

        offres.add(new Offre(3, "Frontend Engineer", "React/Vue developer", "CDI", 4000, "Berlin", new Date()));
        offres.get(2).setEntreprise(google);
        offres.get(2).setDomain(it);
    }
}
