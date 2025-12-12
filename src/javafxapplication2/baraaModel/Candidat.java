package javafxapplication2.baraaModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Candidat extends Person {
    private String telephone;
    private String lettreMotivation;
    private File cv;
    private List<String> competences;
    private List<Postulation> postulations;

    public Candidat() {
        this.competences = new ArrayList<>();
    }

    public Candidat(int id, String nom, String prenom, String email, String password, String telephone, String lettreMotivation, File cv, List<String> competences) {
        super(id, nom, prenom, email, password);
        this.telephone = telephone;
        this.lettreMotivation = lettreMotivation;
        this.cv = cv;
        this.competences = competences != null ? new ArrayList<>(competences) : new ArrayList<>();
        this.postulations = new ArrayList<>();
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getLettreMotivation() { return lettreMotivation; }
    public void setLettreMotivation(String lettreMotivation) { this.lettreMotivation = lettreMotivation; }

    public File getCv() { return cv; }
    public void setCv(File cv) { this.cv = cv; }

    public List<String> getCompetences() { return new ArrayList<>(competences); }
    public void setCompetences(List<String> competences) { this.competences = new ArrayList<>(competences); }

    // Méthodes du diagramme
    public List<Offre> consulterOffres() {
        // Implémentation temporaire - devrait utiliser un service
        return new ArrayList<>();
    }

    public boolean postuler(Offre offre, String lettreMotivation) {
        // Implémentation temporaire - devrait créer une postulation
        return true;
    }

    public String suivreEtatCandidature(int idPostulation) {
        // Implémentation temporaire - devrait récupérer le statut
        return "En attente";
    }

    public void modifierProfil() {
        // Implémentation temporaire
        System.out.println("Profil modifié");
    }

    public void modifierStatutCandidature(int idPostulation, String nouveauStatut) {
        // Implémentation temporaire - devrait modifier le statut d'une postulation
        System.out.println("Statut de la postulation " + idPostulation + " modifié à " + nouveauStatut);
    }

    public void suivreEtatCandidatures() {
        // Implémentation temporaire - devrait afficher l'état de toutes les candidatures
        System.out.println("État des candidatures:");
        for (Postulation p : postulations) {
            System.out.println("Postulation " + p.id() + ": " + p.status());
        }
    }

    public List<Postulation> getPostulations() { return new ArrayList<>(postulations); }

    public void ajouterPostulation(Postulation postulation) {
        if (postulation != null && !this.postulations.contains(postulation)) {
            this.postulations.add(postulation);
        }
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telephone='" + telephone + '\'' +
                ", lettreMotivation='" + lettreMotivation + '\'' +
                ", cv=" + (cv != null ? cv.getName() : "null") +
                ", competences=" + competences +
                '}';
    }
}
