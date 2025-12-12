package javafxapplication2.baraaModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Offre extends Entity {

    private String titre;
    private String description;
    private String typeContrat;
    private double salaire;
    private String localisation;
    private Date datePublication;
    private Date dateExpiration;
    private boolean active;
    private Entreprise entreprise;
    private Domain domain;
    private List<Postulation> postulations;
    private int nombrePostulations;

    public Offre() {
        super();
        this.postulations = new ArrayList<>();
        this.datePublication = new Date();
        this.active = true;
    }

    public Offre(int id, String titre, String description, String typeContrat,
            double salaire, String localisation, Date dateExpiration) {
        super(id);
        this.titre = titre;
        this.description = description;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
        this.localisation = localisation;
        this.dateExpiration = dateExpiration;
        this.postulations = new ArrayList<>();
        this.datePublication = new Date();
        this.active = true;
    }

    public Offre(int i, String fullStack_Developer, String google, String remote, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public List<Postulation> getPostulations() {
        return postulations;
    }

    // Méthodes métier
    public boolean estExpiree() {
        return new Date().after(dateExpiration);
    }

    public void ajouterPostulation(Postulation postulation) {
        if (postulation != null && !this.postulations.contains(postulation)) {
            this.postulations.add(postulation);
            // Postulation is now a record, no setter
        }
    }

    public int getNombrePostulations() {
        return this.postulations.size();
    }

    public void supprimerPostulation(Postulation postulation) {
        if (postulation != null) {
            this.postulations.remove(postulation);
        }
    }

    public void incrementerNombrePostulations() {
        // This method is called when a new postulation is added
        // The count is maintained by the size of the postulations list
    }

    public void desactiverOffre() {
        this.active = false;
    }

    public void mettreAJourOffre(Offre nouvelleOffre) {
        if (nouvelleOffre != null) {
            this.titre = nouvelleOffre.getTitre();
            this.description = nouvelleOffre.getDescription();
            this.typeContrat = nouvelleOffre.getTypeContrat();
            this.salaire = nouvelleOffre.getSalaire();
            this.localisation = nouvelleOffre.getLocalisation();
            this.dateExpiration = nouvelleOffre.getDateExpiration();
            this.domain = nouvelleOffre.getDomain();
            this.entreprise = nouvelleOffre.getEntreprise();
        }
    }

    public String toString() {
        return "Offre{"
                + "id=" + id
                + ", titre='" + titre + '\''
                + ", entreprise=" + (entreprise != null ? entreprise.getNom() : "Non assignée")
                + ", active=" + active
                + ", nombrePostulations=" + postulations.size()
                + '}';
    }
}
