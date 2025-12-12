package javafxapplication2.hayderService;

import javafxapplication2.baraaModel.Candidat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateService {

    private List<Candidat> candidates;

    public CandidateService() {
        candidates = new ArrayList<>();
        loadDummyData();
    }

    public List<Candidat> getAll() {
        return new ArrayList<>(candidates);
    }

    public List<Candidat> search(String keyword) {
        if(keyword == null || keyword.isEmpty()) return getAll();
        String lower = keyword.toLowerCase();
        return candidates.stream()
                .filter(c -> (c.getNom() + " " + c.getPrenom()).toLowerCase().contains(lower)
                        || c.getEmail().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public void addCandidate(Candidat c) {
        if(c != null) candidates.add(c);
    }

    private void loadDummyData() {
        candidates.add(new Candidat(1,"John","Doe","john@example.com","pass","","",null,null));
        candidates.add(new Candidat(2,"Jane","Smith","jane@example.com","pass","","",null,null));
        candidates.add(new Candidat(3,"Alice","Brown","alice@example.com","pass","","",null,null));
    }
}
