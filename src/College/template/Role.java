package College.template;

public class Role {

    private byte id;
    private String nom ;

    public Role(byte id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public byte getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    @Override
    public String toString(){
        return "{ \n Role_id : " + this.getId() + " , \n Nom : " + this.getNom() + " \n} \n" ;
    }
}
