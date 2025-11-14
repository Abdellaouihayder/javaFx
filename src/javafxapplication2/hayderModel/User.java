
package javafxapplication2.hayderModel;


import java.time.LocalDate;
import javafxapplication2.hayder.Exception.AuthException;
import javafxapplication2.hayder.Interfaces.Connexion;




public sealed abstract class User implements Connexion permits Admin, Recruteur {

    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private LocalDate dateCreation;   
    private String role;              

    public User(String id, String nom, String prenom, String email, String motDePasse, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.dateCreation = LocalDate.now(); // Date auto au moment de la création
    }

    @Override
    public void sAuthentifier(String motDePasse) throws AuthException {
        if (motDePasse == null || motDePasse.isEmpty())
            throw new AuthException("Mot de passe vide !");
        if (!this.motDePasse.equals(motDePasse))
            throw new AuthException("Mot de passe incorrect !");
        System.out.println("✅ Authentification réussie pour " + nom + " (" + role + ")");
    }

    @Override
    public void deconnecter() {
        System.out.println(this.nom + " s'est déconnecté.");
    }

    @Override
    public void recupererMotDePasseOublier() {
        System.out.println("📩 Email de récupération envoyé à " + email);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "👤 User { " +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", dateCreation=" + dateCreation +
                " }";
    }
}
