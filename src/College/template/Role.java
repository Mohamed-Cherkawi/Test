package College.template;
import java.util.HashMap; // import the HashMap class

public class Role {
    private HashMap<Integer, String> RoleArray = new HashMap<>();
    private byte id;
    private String nom ;

    public Role() {
        this.RoleArray.put(1, "Admin");
        this.RoleArray.put(2, "Professeur");
        this.RoleArray.put(3, "Etudiant");
    }

    public int loopRoleArr_getNumOfKeys(){
        // Looping through the Hash
        int counter = 0 ;
        for (int key : RoleArray.keySet()) {
            System.out.println("id_role : { " + key + " } -->> : [ " + RoleArray.get(key) + " ]");
            counter++;
        }
        return counter ;
    }

    public String getRoleNameById(int key){
        return RoleArray.get(key);
    }
}
