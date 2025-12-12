package javafxapplication2.baraa.Interfaces;

import javafxapplication2.baraaModel.Exception.PostulationException;
import javafxapplication2.baraaModel.Postulation;


public interface PostulationInterface {
    void ajouterPostulation(Postulation postulation) throws PostulationException;
    void supprimerPostulation(int id) throws PostulationException;
    Postulation trouverPostulation(int id) throws PostulationException;
    void mettreAJourPostulation(Postulation postulation) throws PostulationException;

    // Méthodes du diagramme
    void anuler(int idPostulation) throws PostulationException;
    void modifierStatut(int idPostulation, String nouveauStatut) throws PostulationException;
}
