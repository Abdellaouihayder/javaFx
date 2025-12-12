package javafxapplication2.baraa.Interfaces;

import javafxapplication2.baraaModel.Entreprise;
import javafxapplication2.baraaModel.Exception.EntrepriseException;



public interface EntrepriseInterface {
    void ajouterEntreprise(Entreprise entreprise) throws EntrepriseException;
    void supprimerEntreprise(int id) throws EntrepriseException;
    Entreprise trouverEntreprise(int id) throws EntrepriseException;
    void mettreAJourEntreprise(Entreprise entreprise) throws EntrepriseException;
}
