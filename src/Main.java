import College.* ;
import College.StudyEnv.Matiere;
import College.template.Role;
import College.users.Admin;
import College.users.Enseignant;

import java.util.Scanner;
import java.util.HashMap; // import the HashMap class


public class Main {

    public static void main(String[] args) {
        // Defining Variables :
        int id , roleId , subjectId , departementId, numOfKeys , choosenNum = 0 ;
        String roleName , collegeName , subjectName , departementName , collegeSite , nom , prenom , telephone , email , date ;
        HashMap<Integer, String> rolesArray , subjectsArray ;
      //  Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
        // Application Menu
        System.out.print("############################### Bienvenue à Win Academy App ############################### \n" +
                " Veuillez Entrez Le Nom Du College : ");
        // Stores the  college name
        collegeName = stringScannerMeth((byte) 0);
        System.out.print(" Veuillez Entrez Le Site Internet De Votre College : ");
        collegeSite = stringScannerMeth((byte) 2);
        //  Creating a new College Object
        College collegeObj = new College((byte) 1 , collegeName , collegeSite);
        // Getting some informations about the user
        System.out.println(" Veuillez Nous Donnez Des Informations Sur Vous : ");
        System.out.println("|->> Veuillez Entrez Un Id : ");
        id = validateUserInputForNum();
        System.out.println("|->> Veuillez Entrez Votre Nom : ");
        nom = stringScannerMeth((byte) 0);
        System.out.println("|->> Veuillez Entrez Votre Prenom : ");
        prenom = stringScannerMeth((byte) 0);
        System.out.println("|->> Veuillez Entrez Votre Telephone : ");
        telephone = stringScannerMeth((byte) 9);
        System.out.println("|->> Veuillez Entrez Votre Email : ");
        email = stringScannerMeth((byte) 2);
        // Instanciate the Role Object
        Role roleObj = new Role();
        // Displaying the roles and getting the number of keys to set the limit
        numOfKeys = roleObj.loopRoleArr_getNumOfKeys();
        roleId = getChoosenUserInputNumber( 1 , numOfKeys , "l' id du role");
        roleName = roleObj.getRoleNameById(roleId);

        // Creating new user ( Admin || Teacher || Student ) Depends on the role selected
        if( roleId == 1 ){
            // Create the Admin Obj
            Admin adminObj = new Admin( (short) id , nom , prenom , telephone , email);
            System.out.println("\n \n *******************************************\n Admin A été Bien Créer \n *******************************************\n \n");
            System.out.println(adminObj);
        }else if( roleId == 2){
            // This function asks the user the join date ( Day & month & year ) and returns the date as result formatted like ( dd - mm - yyyy )
            date = getDate();
            // Creating the Subject Object to create All the Subjects available
            Matiere matiereObj = new Matiere();
            // Displaying all the subjects and getting the number of keys to set the limit
            numOfKeys = matiereObj.loopMatiereArr_getNumOfKeys();
            // Asking the teacher to type the id of the subject
            subjectId = getChoosenUserInputNumber(1 , numOfKeys ,"L'id De Matiere Que Vous Enseignez");
            // Getting the name of subject by the given id
            subjectName = matiereObj.getMatiereNameById((byte) subjectId);
            // Creating the Departement Object to create All the Departements available
            Departement departementObj = new Departement();
            // Displaying all the departement and getting the number of keys to set the limit
            numOfKeys = departementObj.loopDepartsArr_getNumOfKeys();
            // Asking the teacher to type the id of the departement that he teaches in
            departementId = getChoosenUserInputNumber(1 , numOfKeys ,"L'id De Département Dont Vous Enseignez");
            // Getting the name of departement by the given id
            departementName = departementObj.getDepartementNameById((byte) departementId);
            // Creating the teacher Object
            Enseignant teacherObj = new Enseignant((short) id , nom , prenom , telephone ,email ,date , subjectName , departementName);
            System.out.println("\n \n ******************************************* \n Enseignant A été Bien Créer \n ******************************************* \n \n");
            System.out.println(teacherObj);
        }
        do {
            System.out.println("############################### Bienveue A ( " + collegeObj.getNom() + " ) College ############################### \n" +
                               "############################### Vous etes un/une { " + roleName +" } ##############################");
            if( roleId == 1 ) {
                // Create a new Admin
                System.out.println(" 1 ->> Gerer un département \n 2 ->> Gerer un Enseignant \n 3 ->> Gerer un étudiant \n 4 ->> Affichage \n 0 ->> Quittez l'application");
                choosenNum = getChoosenUserInputNumber( 0 , 4 , "le numero");
            }else if( roleId == 2 ) {
                System.out.println(" 1 ->> Gerer un Enseignant \n 2 ->> Gerer un étudiant \n 3 ->> Affichage \n 0 ->> Quittez l'application");
                choosenNum = getChoosenUserInputNumber( 0 , 3 , "le numero");
            }else {
                System.out.println(" 1 ->> Affichage \n 0 ->> Quittez l'application");
                choosenNum = getChoosenUserInputNumber( 0 , 1 , "le numero");
            }
            // Getting the chosen number
            switch (choosenNum) {
                case 1:
                    manageDepartement();
                    break;
                case 2:
                    manageTeacher();
                    break;
                case 3:
                    manageStudent();
                    break;
                case 4:
                    show();
            }

        }while (choosenNum != 0) ;
         System.out.println("##################### A Plus Tard Win Academy App ;) ###########################");
    }

    public static void manageDepartement(){
        // Variables
        int choosenNum = 0 ;
        do {
            System.out.println("============================================== Departement Section ==============================================================\n 1 ->> Ajouter un département \n" +
                    " 2 ->> Modifier Un Département \n 3 ->> Afficher Un Ou Plusieurs Départements \n 4 ->> Supprimer Un Département \n 0 ->> Retour \n");

            choosenNum = getChoosenUserInputNumber( 0 ,  4 , "Le Numero");

            switch (choosenNum) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

            }

        }while(choosenNum != 0 );


    }

    public static void manageTeacher(){}

    public static void manageStudent(){}

    public static void show(){}

    public static int getChoosenUserInputNumber(int start , int end , String text){
        // Defining Variables :
        int choosenNum ;
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
        System.out.print(" \nVeuillez Entrez " + text + " Içi : ");
        do {
            if (scanerObj.hasNextInt()) { // Checking what users typed before he submittes , to know what type of data he entered
                choosenNum = scanerObj.nextInt();
                if (choosenNum >= start && choosenNum <= end) {
                    break;
                }
            }
            System.out.print(" Veuillez Entrez Un Numero Existant : ");
            // Clearing Buffer so it refreshes , to read again from the user
            scanerObj.next();

        } while (true);
        return choosenNum ;
    }

    public static int validateUserInputForNum(){
        // Defining Variable :
        int choosenNumber ;
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs

        do {
            if (scanerObj.hasNextInt()) { // Checking what users typed before he submittes , to know what type of data he entered
                choosenNumber = scanerObj.nextInt();
                break;
            }
            System.out.print(" Veuillez Entrez Un Numero  : ");
            // Clearing Buffer so it refreshes , to read again from the user
            scanerObj.next();

        } while (true);
        return  choosenNumber ;
    }

    public static String stringScannerMeth( byte length){
        // Defining Variable :
        String Text ;
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
        do {
            Text = scanerObj.nextLine();
            if( Text.length() > length ){
                break;
            }
            System.out.print(" Champ Textuelle Ne Peut Pas être Vide Ou Inférieure à [ "+ ( length + 1 ) +" ] Caractère : ");

        }while(true);

        return Text ;

    }

    public static int numberScannerMeth(int length){
        int number ;
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
        do {
            number = scanerObj.nextInt();
            if( String.valueOf(number).length() == length ){
                break;
            }
            System.out.print(" Champ Numérique Ne Peut Pas être Vide Et Doit être égale à [ "+ length +" ] Nombres : ");

        }while(true);

        return number ;
    }

    public static String getDate(){
        int day , month , year ;
        String date ;
        System.out.println(" |-> Veuillez Entrez Votre Date D' entrée  ");
        System.out.println("Entrez Le Jour En ( dd ) : ");
        day = numberScannerMeth(2);
        System.out.println("Entrez Le Mois En ( mm ) : ");
        month = numberScannerMeth(2);
        System.out.println("Entrez L' année En ( yyyy ) : ");
        year = numberScannerMeth(4);
        date = day + " - " + month + " - " + year ;
        return date ;
    }

}