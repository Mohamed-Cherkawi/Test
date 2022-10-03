package College.StudyEnv;

import java.util.HashMap;

public class Matiere {

    private HashMap<Integer, String> matiereArray = new HashMap<>();
    private byte id ;
    private String nom ;

// Salle Class
    public Matiere() {
        this.matiereArray.put(1, "Physique");
        this.matiereArray.put(2, "Science Vie & Terre");
        this.matiereArray.put(3, "Programmation");
        this.matiereArray.put(4 , "Sport");
        this.matiereArray.put(5 , "Philosophie");
        this.matiereArray.put(6 , "Mathematique");
    }
    public void setMatiereArra(HashMap<Integer, String> matiereArra) {
        this.matiereArray = matiereArra;
    }

    public int loopMatiereArr_getNumOfKeys(){
        int counter = 0;
        for (int key : matiereArray.keySet()) {
            System.out.println("id_matiere : { " + key + " } -->> : [ " + matiereArray.get(key) + " ]");
            counter++;
        }
        return counter ;
    }

    public String getMatiereNameById(byte key){
        return matiereArray.get((int)key);
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
