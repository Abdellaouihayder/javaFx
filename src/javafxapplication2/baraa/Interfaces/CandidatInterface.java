package javafxapplication2.baraa.Interfaces;

import java.util.List;
import javafxapplication2.baraaModel.Candidat;
import javafxapplication2.baraaModel.Exception.CandidatException;
import javafxapplication2.baraaModel.Offre;


public interface CandidatInterface {
    void ajouterCandidat(Candidat candidat) throws CandidatException;
    void supprimerCandidat(int id) throws CandidatException;
    Candidat trouverCandidat(int id) throws CandidatException;
    void mettreAJourCandidat(Candidat candidat) throws CandidatException;

    // Méthodes du diagramme
    List<Offre> consulterOffres() throws CandidatException;
    boolean postuler(Offre offre, String lettreMotivation) throws CandidatException;
    String suivreEtatCandidature(int idPostulation) throws CandidatException;
    void modifierProfil() throws CandidatException;
}
