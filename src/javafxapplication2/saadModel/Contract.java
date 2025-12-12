package javafxapplication2.saadModel;
import javafxapplication2.saadInterface.IDatable;


public class Contract implements IDatable {
    private int idContract;
    private String clientName;       
    private String typeContract;
    private SEDate dateDebut;
    private SEDate dateFin;
    private float salaire;

    public Contract(int idContract, String clientName, String typeContract, SEDate dateDebut, SEDate dateFin, float salaire) {
        this.idContract = idContract;
        this.clientName = clientName;
        this.typeContract = typeContract;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.salaire = salaire;
    }

    public void validerContract() { }
    public void resilierContract() { }
    public void renouvelerContract() { }

    @Override
    public void setDate(SEDate d) { this.dateDebut = d; }

    @Override
    public SEDate getDate() { return dateDebut; }

    // ---------------- GETTERS & SETTERS ---------------- //

    public int getIdContract() { return idContract; }
    public void setIdContract(int idContract) { this.idContract = idContract; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getTypeContract() { return typeContract; }
    public void setTypeContract(String typeContract) { this.typeContract = typeContract; }

    public SEDate getDateDebut() { return dateDebut; }
    public void setDateDebut(SEDate dateDebut) { this.dateDebut = dateDebut; }

    public SEDate getDateFin() { return dateFin; }
    public void setDateFin(SEDate dateFin) { this.dateFin = dateFin; }

    public float getSalaire() { return salaire; }
    public void setSalaire(float salaire) { this.salaire = salaire; }
}
