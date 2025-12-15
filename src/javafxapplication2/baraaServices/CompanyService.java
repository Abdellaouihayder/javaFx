package javafxapplication2.baraaServices;

import javafxapplication2.hayderService.*;
import javafxapplication2.baraaModel.Entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {

    private List<Entreprise> companies;

    public CompanyService() {
        companies = new ArrayList<>();
        loadDummyData();
    }

    public List<Entreprise> getAll() {
        return new ArrayList<>(companies);
    }

    public List<Entreprise> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAll();
        }
        String lower = keyword.toLowerCase();
        return companies.stream()
                .filter(c -> c.getNom().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public void addCompany(Entreprise company) {
        if (company != null) {
            companies.add(company);
        }
    }

    private void loadDummyData() {
        companies.add(new Entreprise(1, "Google"));
        companies.add(new Entreprise(2, "Amazon"));
        companies.add(new Entreprise(3, "Microsoft"));
        companies.add(new Entreprise(4, "Facebook"));
    }
}
