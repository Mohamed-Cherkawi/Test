package College.StudyEnv;

import java.util.HashMap;

public class Matiere {

    private byte id ;
    private String nom ;

// Salle Class
    public Matiere(byte id , String nom) {
        this.id = id;
        this.nom = nom;
    }
    @Override
    public String toString(){
        return "{ \n matiere_id : " + this.getId() + " , \n Nom : " + this.getNom() + " \n} \n" ;
    }
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
