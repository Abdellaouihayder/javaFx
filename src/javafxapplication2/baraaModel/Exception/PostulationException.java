package javafxapplication2.baraaModel.Exception;

public class PostulationException extends Exception {
    private int candidatId;
    private int offreId;

    public PostulationException(String message, int candidatId, int offreId) {
        super(message);
        this.candidatId = candidatId;
        this.offreId = offreId;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public int getOffreId() {
        return offreId;
    }
}
