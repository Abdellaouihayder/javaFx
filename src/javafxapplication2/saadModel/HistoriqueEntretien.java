package javafxapplication2.saadModel;

import javafxapplication2.saadInterface.IDatable;
import javafxapplication2.saadInterface.IHistorisable;


public class HistoriqueEntretien implements IHistorisable, IDatable {
    private int id;
    private int idCandidat;
    private SEDate dateEntretien;
    private String resultat;

    public HistoriqueEntretien(int id, int idCandidat, SEDate dateEntretien, String resultat) {
        this.id = id;
        this.idCandidat = idCandidat;
        this.dateEntretien = dateEntretien;
        this.resultat = resultat;
    }

    @Override
    public void ajouter() { }
    @Override
    public void modifier() { }
    @Override
    public void supprimer() { }

    @Override
    public void setDate(SEDate d) { this.dateEntretien = d; }
    @Override
    public SEDate getDate() { return dateEntretien; }

    // Getters et Setters...
}