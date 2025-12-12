package javafxapplication2.baraaModel;

public abstract sealed class Entity permits Person, Entreprise, Domain, Offre {
    protected int id;

    public Entity() {
        this.id = 0;
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
