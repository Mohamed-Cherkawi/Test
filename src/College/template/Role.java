package College.template;
import java.util.HashMap; // import the HashMap class

public class Role {
    private HashMap<Integer, String>  RoleArra;
    private byte id;
    private String nom ;

    public void setRoleArra(HashMap<Integer, String> roleArra) {
        RoleArra = roleArra;
    }

    public HashMap<Integer, String> getRoleArra() {
        return RoleArra;
    }

    public Role() {
        HashMap<Integer, String> RoleArray = new HashMap<Integer, String>();
        RoleArray.put(1, "Admin");
        RoleArray.put(2, "Professeur");
        RoleArray.put(3, "Etudiant");
        // Setting The role array
        this.setRoleArra(RoleArray);
        System.out.println(this.getRoleArra());
    }

}
