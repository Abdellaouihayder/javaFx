package javafxapplication2.saadModel;

import javafxapplication2.saadInterface.IDatable;
import javafxapplication2.saadInterface.IHistorisable;



/**
 * Historique général — Partie développée par Saad Eddine
 */
public class Historique implements IHistorisable, IDatable {
    private int id;
    private String description;
    private SEDate date;

    public Historique(int id, String description, SEDate date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    @Override
    public void ajouter() { }
    @Override
    public void modifier() { }
    @Override
    public void supprimer() { }

    @Override
    public void setDate(SEDate d) { this.date = d; }
    @Override
    public SEDate getDate() { return date; }

    // Getters et Setters...
}