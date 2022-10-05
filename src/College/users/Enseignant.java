package College.users;

import College.Departement;
import College.StudyEnv.Matiere;
import College.template.User;

public class Enseignant extends User {

    // User Class
    private String dateFonction;
    private Matiere matiere;
    private Departement departement;
    //Departement


    public Enseignant(short id, String nom, String prenom, String telephone, String email, String dateFonction, Matiere matiere, Departement departement) {
        super(id, nom, prenom, telephone, email);
        this.dateFonction = dateFonction;
        this.matiere = matiere;
        this.departement = departement;
    }

    public String afficherFicheEnseignant(){
        return null ;
    }

    @Override
    public String toString(){
        return "{ \n   Id -> " + getId() + "\n   Nom -> " + getNom() + "\n   Prenom -> " + getPrenom() + "\n   Telephone -> " + getTelephone()
                + "\n   Email -> " + getEmail() + "\n   Date De Fonction -> " + getDateFonction() +  "\n   Enseigne -> " + getMatiere()
                + "\n   En Département de -> " + getDepartement() + " \n}";
    }
    public String getDateFonction() {
        return dateFonction;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Departement getDepartement() {
        return departement;
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
