package College.users;

import College.template.User;

public class Admin  extends User {

    public Admin(short id, String nom, String prenom, String telephone, String email) {
        super(id, nom, prenom, telephone, email);
    }
    @Override
    public String toString(){
        return "{ \n   Id -> " + getId() + "\n   Nom -> " + getNom() + "\n   Prenom -> " + getPrenom() + "\n   Telephone -> " + getTelephone()
                + "\n   Email -> " + getEmail() + " \n}";
    }
    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }

    @Override
    public String search() {
        return null;
    }
}
