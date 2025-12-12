package javafxapplication2.baraaModel;

import javafxapplication2.baraaModel.Exception.GestionOffreException;

public final class Recruteur extends Person {
    private Entreprise entreprise;

    public Recruteur() {
        super();
    }

    public Recruteur(int id, String nom, String prenom, String email, String password) {
        super(id, nom, prenom, email, password);
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Entreprise getEntreprise() { return entreprise; }
    public void setEntreprise(Entreprise entreprise) { this.entreprise = entreprise; }

    public void publierOffre(Offre offre) throws GestionOffreException {
        if (offre == null) {
            throw new GestionOffreException("L'offre ne peut pas être nulle");
        }

        if (entreprise == null) {
            throw new GestionOffreException("Le recruteur doit être associé à une entreprise");
        }
        entreprise.ajouterOffre(offre);
    }

    public void modifierOffre(int offreId, Offre nouvelleOffre) throws GestionOffreException {
        if (nouvelleOffre == null) {
            throw new GestionOffreException("La nouvelle offre ne peut pas être nulle");
        }
        if (entreprise == null) {
            throw new GestionOffreException("Le recruteur doit être associé à une entreprise");
        }
        Offre offreExistante = entreprise.getOffres().stream()
                .filter(o -> o.getId() == offreId)
                .findFirst()
                .orElse(null);
        if (offreExistante == null) {
            throw new GestionOffreException("Offre non trouvée avec ID: " + offreId);
        }
        entreprise.getOffres().remove(offreExistante);
        entreprise.getOffres().add(nouvelleOffre);
    }

    public void supprimerOffre(int offreId) throws GestionOffreException {
        if (entreprise == null) {
            throw new GestionOffreException("Le recruteur doit être associé à une entreprise");
        }
        Offre offre = entreprise.getOffres().stream()
                .filter(o -> o.getId() == offreId)
                .findFirst()
                .orElse(null);
        if (offre == null) {
            throw new GestionOffreException("Offre non trouvée avec ID: " + offreId);
        }
        entreprise.supprimerOffre(offre);
    }

    public String genererStatistiquesOffres() {
        if (entreprise == null) {
            return "Aucune entreprise associée";
        }
        long totalOffres = entreprise.getOffres().size();
        long offresActives = entreprise.getOffres().stream()
                .filter(Offre::isActive)
                .count();
        long totalPostulations = entreprise.compterPostulationsTotales();
        return String.format("Total offres: %d, Offres actives: %d, Total postulations: %d",
                           totalOffres, offresActives, totalPostulations);
    }

    @Override
    public String toString() {
        return "Recruteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", entreprise=" + (entreprise != null ? entreprise.getNom() : "null") +
                '}';
    }
}
