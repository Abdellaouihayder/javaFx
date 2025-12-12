package javafxapplication2.baraa.Interfaces;

import javafxapplication2.baraaModel.Exception.RecruteurException;
import javafxapplication2.hayderModel.Recruteur;


public interface RecruteurInterface {
    void ajouterRecruteur(Recruteur recruteur) throws RecruteurException;
    void supprimerRecruteur(int id) throws RecruteurException;
    Recruteur trouverRecruteur(int id) throws RecruteurException;
    void mettreAJourRecruteur(Recruteur recruteur) throws RecruteurException;
}
