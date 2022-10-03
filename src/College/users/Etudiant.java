package College.users;

import College.template.User;

public class Etudiant extends User {

    //User Class
    private String dateEntree ;

    public Etudiant(short id, String nom, String prenom, String telephone, String email, String dateEntree) {
        super(id, nom, prenom, telephone, email);
        this.dateEntree = dateEntree;
    }

    public String getInfos() {
        return null ;
    }
    public String afficherFicheEtudiant() {
        return null ;
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
