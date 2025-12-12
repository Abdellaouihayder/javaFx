package javafxapplication2.saadModel;

import javafxapplication2.saadInterface.IDatable;
import javafxapplication2.saadInterface.IHistorisable;


public class HistoriqueContact implements IHistorisable, IDatable {
    private int id;
    private int idContact;
    private SEDate dateContact;
    private String note;

    public HistoriqueContact(int id, int idContact, SEDate dateContact, String note) {
        this.id = id;
        this.idContact = idContact;
        this.dateContact = dateContact;
        this.note = note;
    }

    @Override
    public void ajouter() { }
    @Override
    public void modifier() { }
    @Override
    public void supprimer() { }

    @Override
    public void setDate(SEDate d) { this.dateContact = d; }
    @Override
    public SEDate getDate() { return dateContact; }

    // Getters et Setters...
}