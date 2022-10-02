import College.* ;
import College.template.Role;

import java.util.Scanner;
import java.util.HashMap; // import the HashMap class


public class Main {

    public static void main(String[] args) {
        // Defining Variables :
        short choosenNum = 0 ;
        int id , roleId ;
        String nom , prenom , telephone , email ;
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
        // Application Menu
        System.out.print("############################### Welcome At Win Academy App ############################### \n" +
                " Veuillez Entrez Le Nom du College : ");
        // Stores the  college name
        String collegeName = scanerObj.nextLine();
        System.out.println("Veuillez nous donnez des informations sur vous : ");
        System.out.println("|->> Veuillez Entrez un id : ");
        id = validateUserInputForNum();
        System.out.println(id);
        System.out.println("|->> Veuillez Entrez votre nom : ");
        nom = stringScannerMeth((byte) 0);
        System.out.println(nom);
        System.out.println("|->> Veuillez Entrez votre prenom : ");
        prenom = stringScannerMeth((byte) 0);
        System.out.println(prenom);
        System.out.println("|->> Veuillez Entrez votre telephone : ");
        telephone = stringScannerMeth((byte) 9);
        System.out.println(telephone);
        System.out.println("|->> Veuillez Entrez votre email : ");
        email = stringScannerMeth((byte) 2);
        System.out.println(email);
        System.out.println("|->> Veuillez Entrez votre role dans le college : ");
        // We want to instanciate the Role Class to get all the roles stored in a HashMap
        Role RoleClass = new Role();
        roleId = getChoosenUserInputNumber((byte) 1 , (byte) 3 , "l' id du role");
        System.out.println(roleId);

        do {
            System.out.println("############################### Welcome At ( " + collegeName + " ) College ############################### \n" +
                    "1 ->> Gerer un département \n 2 ->> Gerer un Enseignant \n 3 ->> Gerer un étudiant \n 4 ->> Affichage \n 0 ->> Quittez l'application \n");

            choosenNum = getChoosenUserInputNumber( (byte) 0 , (byte) 4 , "le numero");
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
         System.out.println("##################### See you later  At Win Academy App ;) ###########################");
    }

    public static void manageDepartement(){
        // Variables
        short choosenNum = 0 ;
        do {
            System.out.println("============================================== Departement Section ==============================================================\n 1 ->> Ajouter un département \n" +
                    " 2 ->> Modifier un département \n 3 ->> Afficher un ou plusieurs départements \n 4 ->> Supprimer un département \n 0 ->> Retour \n");

            choosenNum = getChoosenUserInputNumber( (byte) 0 , (byte) 4 , "le numero");

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

    public static short getChoosenUserInputNumber(short start , short end , String text){
        // Defining Variables :
        short choosenNum ;
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
        System.out.print(" Veuillez Entrez " + text + " içi : ");
        do {
            if (scanerObj.hasNextByte()) { // Checking what users typed before he submittes , to know what type of data he entered
                choosenNum = scanerObj.nextByte();
                if (choosenNum >= start && choosenNum <= end) {
                    break;
                }
            }
            System.out.print(" Veuillez entrez un numero existant : ");
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
            System.out.print(" Veuillez entrez un numero  : ");
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
            System.out.print(" Champ Textuelle ne peut pas être vide ou inférieure à [ "+ length + 1 +" ] Caractère : ");

        }while(true);

        return Text ;

    }

}