package javafxapplication2.saadModel;

import javafxapplication2.saadInterface.IDatable;


/**
 * Evaluation — Partie développée par Saad Eddine
 */
public class Evaluation implements IDatable {
    private int idEval;
    private int idEmploye;
    private SEDate dateEval;
    private float note;
    private String commentaire;

    public Evaluation(int idEval, int idEmploye, SEDate dateEval, float note, String commentaire) {
        this.idEval = idEval;
        this.idEmploye = idEmploye;
        this.dateEval = dateEval;
        this.note = note;
        this.commentaire = commentaire;
    }

    public void ajouterEvaluation() { }
    public void modifierEvaluation() { }
    public void supprimerEvaluation() { }

    @Override
    public void setDate(SEDate d) { this.dateEval = d; }
    @Override
    public SEDate getDate() { return dateEval; }

    // Getters et Setters...
}