package javafxapplication2.baraaServices;

import javafxapplication2.hayderService.*;
import javafxapplication2.baraaModel.Domain;
import java.util.ArrayList;
import java.util.List;

public class DomainService {

    private final List<Domain> domains = new ArrayList<>();

    public DomainService() {
        loadFakeData();
    }

    private void loadFakeData() {
        domains.add(new Domain(1, "Informatique", "Développement, IA, Réseau..."));
        domains.add(new Domain(2, "Médecine", "Santé, paramédical, soins."));
        domains.add(new Domain(3, "Économie", "Finance, business, commerce."));
        domains.add(new Domain(4, "Éducation", "Enseignement, formation."));
        domains.add(new Domain(5, "Ingénierie", "Mécanique, civil, industriel."));
    }

    public List<Domain> getAll() {
        return domains;
    }

    public List<Domain> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAll();
        }
        return domains.stream()
                .filter(d -> d.getNom().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
