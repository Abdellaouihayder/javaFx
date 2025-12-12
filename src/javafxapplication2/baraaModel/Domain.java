package javafxapplication2.baraaModel;

import java.util.ArrayList;
import java.util.List;

public final class Domain extends Entity {
    private String nom;
    private String description;
    private List<Offre> offres;

    public Domain() {
        super();
        this.offres = new ArrayList<>();
    }

    public Domain(int id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
        this.offres = new ArrayList<>();
    }

    // Getters et setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Offre> getOffres() { return offres; }

    public void ajouterOffre(Offre offre) {
        if (offre != null && !this.offres.contains(offre)) {
            this.offres.add(offre);
            offre.setDomain(this);
        }
    }

    public void supprimerOffre(Offre offre) {
        if (offre != null) {
            this.offres.remove(offre);
            offre.setDomain(null);
        }
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", nombreOffres=" + offres.size() +
                '}';
    }
}
