package College;

public class College {

    private byte id ;

    private String nom ;
    private String Lien_Site_Internet ;

    public College(byte id, String nom, String lien_Site_Internet) {
        this.id = id;
        this.nom = nom;
        this.Lien_Site_Internet = lien_Site_Internet;
    }

    public String getNom() {
        return nom;
    }
}
