package College;

import java.util.HashMap;

public class Departement {

    private HashMap<Integer, String> DepartementArray = new HashMap<>();
    private byte id ;

    private String nom ;
    // College Class
    // Responsable : Enseignant

    public Departement(byte id , String nom) {
        this.id = id;
        this.nom = nom;
    }
    @Override
    public String toString(){
        return "\n{ \n Departement_id : " + this.getId() + " , \n Nom : " + this.getNom() + " \n} ,\n" ;
    }

    public void showDepartements(){}

    public void showDepartementById(){}

    public void deleteDepartementById(){}

    public byte getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

}
