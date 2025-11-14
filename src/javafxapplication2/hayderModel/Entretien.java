/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2.hayderModel;


import java.time.LocalDate;
import javafxapplication2.hayder.Exception.EntretienPlanningException;

public class Entretien {
    private int id;
    private LocalDate dateEntretien;
    private String type;
    private String compteRendu;

    public Entretien(int id, LocalDate dateEntretien, String type) {
        this.id = id;
        this.dateEntretien = dateEntretien;
        this.type = type;
    }

    public void planifier(LocalDate date, String type) throws EntretienPlanningException {
        if (date.isBefore(LocalDate.now())) {
            throw new EntretienPlanningException("La date d’entretien est invalide !");
        }
        this.dateEntretien = date;
        this.type = type;
        System.out.println("Entretien planifié le " + date + " de type " + type);
    }

    public void enregistrerCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
        System.out.println("Compte rendu enregistré pour l’entretien n°" + id);
    }
}

