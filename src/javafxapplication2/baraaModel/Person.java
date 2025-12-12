package javafxapplication2.baraaModel;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract sealed class Person extends Entity permits Candidat, Recruteur {
    protected String nom;
    protected String prenom;
    protected String email;
    protected String password;

    public Person() {
        super();
    }

    public Person(int id, String nom, String prenom, String email, String password) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Functional interface usage
    public boolean authentifier(String email, String password) {
        Predicate<String> emailMatcher = e -> this.email.equals(e);
        Predicate<String> passwordMatcher = p -> this.password.equals(p);
        return emailMatcher.test(email) && passwordMatcher.test(password);
    }

    // Functional interface for name formatting
    public String getFullName() {
        Function<Person, String> fullNameFormatter = p -> p.getPrenom() + " " + p.getNom();
        return fullNameFormatter.apply(this);
    }

    public void changerMotDePasse(String nouveauMotDePasse) {
        if (nouveauMotDePasse == null || nouveauMotDePasse.length() < 6) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 6 caractères");
        }
        this.password = nouveauMotDePasse;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
