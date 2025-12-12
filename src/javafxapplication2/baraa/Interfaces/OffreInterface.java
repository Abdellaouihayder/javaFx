package javafxapplication2.baraa.Interfaces;

import javafxapplication2.baraaModel.Exception.OffreException;
import javafxapplication2.baraaModel.Offre;



public interface OffreInterface {
    void ajouterOffre(Offre offre) throws OffreException;
    void supprimerOffre(int id) throws OffreException;
    Offre trouverOffre(int id) throws OffreException;
    void mettreAJourOffre(Offre offre) throws OffreException;
}
