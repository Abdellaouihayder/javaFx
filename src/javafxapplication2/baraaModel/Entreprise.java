package javafxapplication2.baraaModel;

import java.util.ArrayList;
import java.util.List;

public non-sealed class Entreprise extends Entity {
    private String nom;
    private String adresse;
    private String secteur;
    private List<Offre> offres;
    private List<Recruteur> recruteurs;
    private List<Domain> domains;

    public Entreprise() {
        this.offres = new ArrayList<>();
        this.recruteurs = new ArrayList<>();
        this.domains = new ArrayList<>();
    }

    public Entreprise(int id, String nom) {
        super(id);
        this.nom = nom;
        this.adresse = "";
        this.secteur = "";
        this.offres = new ArrayList<>();
        this.recruteurs = new ArrayList<>();
        this.domains = new ArrayList<>();
    }

    public Entreprise(int id, String nom, String adresse, String secteur) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.secteur = secteur;
        this.offres = new ArrayList<>();
        this.recruteurs = new ArrayList<>();
        this.domains = new ArrayList<>();
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getSecteur() { return secteur; }
    public void setSecteur(String secteur) { this.secteur = secteur; }

    public List<Offre> getOffres() { return offres; }
    public List<Recruteur> getRecruteurs() { return recruteurs; }
    public List<Domain> getDomains() { return domains; }

    // Gestion des offres
    public void ajouterOffre(Offre offre) {
        if (offre != null && !this.offres.contains(offre)) {
            this.offres.add(offre);
            offre.setEntreprise(this);
        }
    }
    public long compterPostulationsTotales() {
        return offres.stream()
                .mapToLong(o -> o.getPostulations().size())
                .sum();
    }
    public void supprimerOffre(Offre offre) {
        if (offre != null) {
            this.offres.remove(offre);
            offre.setEntreprise(null);
        }
    }

    // Streams et utilitaires
    public List<Offre> getOffresActives() {
        return offres.stream().filter(Offre::isActive).toList();
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", secteur='" + secteur + '\'' +
                '}';
    }
}
