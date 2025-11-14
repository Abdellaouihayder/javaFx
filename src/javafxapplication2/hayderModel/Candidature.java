/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2.hayderModel;


import java.time.LocalDate;

public class Candidature {
    private int id;
    private LocalDate dateSoumission;
    private String statut;
    private String messageMotivation;

    public Candidature(int id, LocalDate dateSoumission, String statut, String messageMotivation) {
        this.id = id;
        this.dateSoumission = dateSoumission;
        this.statut = statut;
        this.messageMotivation = messageMotivation;
    }

    public void modifierStatut(String statut) {
        this.statut = statut;
        System.out.println("Statut de la candidature modifié : " + statut);
    }

    public void consulterInformationSurEntretien() {
        System.out.println("Consultation des informations d’entretien pour la candidature n°" + id);
    }
}
