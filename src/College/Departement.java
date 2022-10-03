package College;

import java.util.HashMap;

public class Departement {

    private HashMap<Integer, String> DepartementArray = new HashMap<>();
    private byte id ;
    private String nom ;
    // College Class
    // Responsable : Enseignant

    public Departement() {
        DepartementArray.put(1 , "Sciences");
        DepartementArray.put(2 , "Expériences");
        DepartementArray.put(3 , "Sport");
        DepartementArray.put(4 , "Litérature");
        DepartementArray.put(5 , "Languages");
    }

    public int loopDepartsArr_getNumOfKeys(){
        // Looping through the Hash
        int counter = 0 ;
        for (int key : DepartementArray.keySet()) {
            System.out.println("id_departement : { " + key + " } -->> : [ " + DepartementArray.get(key) + " ]");
            counter++;
        }
        return counter ;
    }

    public String getDepartementNameById(int key){
        return DepartementArray.get(key);
    }
    public void addDepartement(){}

    public void showDepartements(){}

    public void showDepartementById(){}

    public void deleteDepartementById(){}
}
