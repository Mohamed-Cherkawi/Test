package College.users;

import College.template.User;

public class Admin  extends User {

    public Admin(short id , String nom , String prenom , String telephone , String email) {
    id = id ;
    nom = nom ;
    prenom = prenom ;
    telephone = telephone ;
    email = email ;
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
