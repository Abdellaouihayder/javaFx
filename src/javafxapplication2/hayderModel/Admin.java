
package javafxapplication2.hayderModel;
import java.util.List;
import javafxapplication2.hayder.Exception.AuthException;
import javafxapplication2.hayder.Exception.UserNotFoundException;

public final class Admin extends User {

    public Admin(String id, String nom, String prenom, String email, String motDePasse) {
        super(id, nom, prenom, email, motDePasse,"Admin");
    }

    public void gestionDesUtilisateurs(List<User> utilisateurs) throws UserNotFoundException {
        if (utilisateurs == null || utilisateurs.isEmpty()) {
            throw new UserNotFoundException("Aucun utilisateur trouvé !");
        }
        System.out.println("👤 Gestion des utilisateurs : " + utilisateurs.size() + " trouvés.");
    }

    public void consulterStatistiques() throws AuthException {
        System.out.println("📊 Statistiques consultées par l'administrateur : " + getNom());
    }
}
