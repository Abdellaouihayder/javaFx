package javafxapplication2.saadModel;

import javafxapplication2.saadInterface.IDatable;


public class Messagerie implements IDatable {
    private int idMessage;
    private String expediteur;
    private String destinataire;
    private String contenu;
    private SEDate dateEnvoi;

    public Messagerie(int idMessage, String expediteur, String destinataire, String contenu, SEDate dateEnvoi) {
        this.idMessage = idMessage;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
    }

    public void envoyerMessage() { }
    public void supprimerMessage() { }
    public void afficherMessages() { }

    @Override
    public void setDate(SEDate d) { this.dateEnvoi = d; }
    @Override
    public SEDate getDate() { return dateEnvoi; }

    // Getters et Setters...
}