package javafxapplication2.baraa.Interfaces;


import java.util.List;
import javafxapplication2.baraaModel.Domain;
import javafxapplication2.baraaModel.Exception.DomainException;


public interface DomainInterface {

    void ajouterDomain(Domain domain) throws DomainException;

    void supprimerDomain(Domain domain) throws DomainException;

    Domain trouverDomainParId(int id) throws DomainException;

    List<Domain> getAllDomains();

    void mettreAJourDomain(Domain domain) throws DomainException;
}
