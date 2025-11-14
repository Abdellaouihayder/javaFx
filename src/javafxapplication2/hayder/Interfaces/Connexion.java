
package javafxapplication2.hayder.Interfaces;


public interface Connexion {
    void sAuthentifier(String p) throws Exception;
    void deconnecter();
    void recupererMotDePasseOublier();
}
