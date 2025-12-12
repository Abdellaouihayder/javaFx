package javafxapplication2.baraaModel;

import java.time.LocalDateTime;

public record Postulation(
    int id,
    Candidat candidat,
    Offre offre,
    String messageMotivation,
    String status,
    LocalDateTime datePostulation
) {
    public Postulation {
        if (candidat == null) {
            throw new IllegalArgumentException("Le candidat ne peut pas être nul");
        }
        if (offre == null) {
            throw new IllegalArgumentException("L'offre ne peut pas être nulle");
        }
        if (status == null || status.trim().isEmpty()) {
            status = "En attente";
        }
        if (datePostulation == null) {
            datePostulation = LocalDateTime.now();
        }
    }

    // Constructor without id (for new postulations)
    public Postulation(Candidat candidat, Offre offre, String messageMotivation) {
        this(0, candidat, offre, messageMotivation, "En attente", LocalDateTime.now());
    }

    // Method to modify status
    public Postulation modifierStatut(String nouveauStatut) {
        return new Postulation(id, candidat, offre, messageMotivation, nouveauStatut, datePostulation);
    }

    @Override
    public String toString() {
        return "Postulation{" +
                "id=" + id +
                ", candidat=" + candidat.getFullName() +
                ", offre=" + offre.getTitre() +
                ", status='" + status + '\'' +
                ", datePostulation=" + datePostulation +
                '}';
    }
}
