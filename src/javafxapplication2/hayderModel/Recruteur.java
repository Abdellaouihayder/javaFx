/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2.hayderModel;

import java.util.List;
import javafxapplication2.hayder.Exception.CandidatureNotFoundException;
import javafxapplication2.hayder.Exception.OfferManagementException;

public final class Recruteur extends User {

    private String poste;
    private String domaineDeTravail;

    public Recruteur(String id, String nom, String prenom, String email, String motDePasse,
                     String poste, String domaineDeTravail) {
        super(id, nom, prenom, email, motDePasse,"Recruteur");
        this.poste = poste;
        this.domaineDeTravail = domaineDeTravail;
    }

    public void gestionDesOffresEntreprise(List<String> offres) throws OfferManagementException {
        if (offres == null || offres.isEmpty()) {
            throw new OfferManagementException("Aucune offre disponible !");
        }
        System.out.println("📄 Offres gérées : " + offres);
    }

    public void gestionDesCandidatures(List<Candidature> candidatures) throws CandidatureNotFoundException {
        if (candidatures == null || candidatures.isEmpty()) {
            throw new CandidatureNotFoundException("Aucune candidature trouvée !");
        }
        System.out.println("📬 Nombre de candidatures reçues : " + candidatures.size());
    }

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }

    public String getDomaineDeTravail() { return domaineDeTravail; }
    public void setDomaineDeTravail(String domaineDeTravail) { this.domaineDeTravail = domaineDeTravail; }

    @Override
    public String toString() {
        return super.toString() + " | Poste: " + poste + ", Domaine: " + domaineDeTravail;
    }
}