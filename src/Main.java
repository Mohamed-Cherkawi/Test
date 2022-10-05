import College.* ;
import College.StudyEnv.*;
import College.users.*;
import College.template.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Defining Variables :
        /************************ Numericals Vars *****************************/
        int id , roleId , subjectId , departementId , choosenNum = 0 ;
        byte departementIdCounter = 1 , subjectIdCounter = 1 ;
        /************************ Strings *****************************/
        String roleName , collegeName , collegeSite , nom , prenom , telephone , email , date ;
        /************************ Booleans *****************************/
        /************************ Objects *****************************/
        Role roleObject ;
        Matiere subjectObj ;
        Departement departementObj ;
        /************************ Lists *****************************/
        // Creating a List of All the departements ( Created By Default )
        ArrayList<Departement> departments = new ArrayList<Departement>();
        Collections.addAll(departments, new Departement(departementIdCounter++ ,"Sciences"),new Departement(departementIdCounter++ , "Expériences"),
                new Departement(departementIdCounter++ , "Sport"),new Departement(departementIdCounter++ ,"Littérature"),new Departement(departementIdCounter++ ,"Languages"));
        // Creating a List of All the subjects ( Created By Default )
        ArrayList<Matiere> subjects = new ArrayList<Matiere>();
        Collections.addAll(subjects, new Matiere(subjectIdCounter++ , "Physique"),new Matiere(subjectIdCounter++ ,"Science Vie & Terre"),
                new Matiere(subjectIdCounter++ ,"Programmation"), new Matiere(subjectIdCounter++ ,"Sport"), new Matiere(subjectIdCounter++ ,"Philosophie")
                , new Matiere(subjectIdCounter++ , "Mathématique"));
        // Creating a List of All the roles ( Created By Default )
        ArrayList<Role> roles = new ArrayList<Role>();
        Collections.addAll(roles , new Role((byte) 1 , "Admin" ) , new Role((byte) 2 ,"Professeur") , new Role((byte) 3 , "Etudiant" ));
        // Creating a List of All the teahcers ( Created By Default )
        ArrayList<Enseignant> teachers = new ArrayList<Enseignant>();
        Collections.addAll(teachers , new Enseignant((short) 1 , "Cherkaoui", "Mohamed" , "0776676767676" , "email@" , "25 - 12 - 2021" ,subjects.get(1),departments.get(0))
                , new Enseignant((short) 2 ,"Cherkaoui" , "Firdaouss" , "061616161616" , "email" , "12 - 03 - 2002",subjects.get(3) , departments.get(2)));
        // Temp List to stores returned new values in array list to insert them on these below ;
        ArrayList<Departement> ReturnedDepartsArr ;
        /************************ Scanner *****************************/
        Scanner scanerObj = new Scanner(System.in); // Create an object from Scanner Class to read inputs
                                /************************ Application  *****************************/
        System.out.print("############################### Bienvenue à Win Academy App ############################### \n" +
                " Veuillez Entrez Le Nom Du College : ");
        // Stores the  college name
        collegeName = stringScannerMeth((byte) 0 , scanerObj);
        System.out.print(" Veuillez Entrez Le Site Internet De Votre College : ");
        collegeSite = stringScannerMeth((byte) 2 , scanerObj);
        //  Creating a new College Object
        College collegeObj = new College((byte) 1 , collegeName , collegeSite);
        // Getting some informations about the user
        System.out.println(" Veuillez Nous Donnez Des Informations Sur Vous : ");
        System.out.println("|->> Veuillez Entrez Un Id : ");
        id = validateUserInputForNum(scanerObj);
        System.out.println("|->> Veuillez Entrez Votre Nom : ");
        nom = stringScannerMeth((byte) 3 , scanerObj);
        System.out.println("|->> Veuillez Entrez Votre Prenom : ");
        prenom = stringScannerMeth((byte) 3 , scanerObj);
        System.out.println("|->> Veuillez Entrez Votre Telephone : ");
        telephone = stringScannerMeth((byte) 9 , scanerObj);
        System.out.println("|->> Veuillez Entrez Votre Email : ");
        email = stringScannerMeth((byte) 2 , scanerObj);
        // Displaying the roles and getting the number of keys to set the limit
        loopThroughRoleList(roles);
        roleId = getChoosenUserInputNumber( 1 , roles.size() , "l' id du role" , scanerObj);
        roleObject = roles.get(roleId - 1);
        roleName = roleObject.getNom();

        // Creating new user ( Admin || Teacher || Student ) Depends on the role selected
        if( roleId == 1 ){
            // Create the Admin Obj
            Admin adminObj = new Admin( (short) id , nom , prenom , telephone , email);
            System.out.println("\n \n *******************************************\n Admin A été Bien Créer \n *******************************************\n \n");
            System.out.println(adminObj);
        }else if( roleId == 2){
            // This function asks the user the join date ( Day & month & year ) and returns the date as result formatted like ( dd - mm - yyyy )
            date = getDate(scanerObj);
            // Displaying all the subjects
            loopThroughMatiereList(subjects);
            // Asking the teacher to type the id of the subject and limit him from 1 to number of elements based on the array
            subjectId = getChoosenUserInputNumber(1 , subjects.size() ,"L'id De Matiere Que Vous Enseignez" , scanerObj);
            // Getting the name of subject by the given id and substract it by one because array indexes start with 0
            subjectObj = subjects.get(subjectId - 1);
            // Displaying all the departements
            loopThroughDepartementList(departments);
            // Asking the teacher to type the id of the departement that he teaches in and limit him from 1 to number of elements based on the array
            departementId = getChoosenUserInputNumber(1 , departments.size() ,"L'id De Département Dont Vous Enseignez" , scanerObj);
            // Getting the name of departement by the given id
            departementObj = departments.get(departementId - 1);
            // Creating the teacher Object
            Enseignant teacherObj = new Enseignant((short) id , nom , prenom , telephone ,email ,date , subjectObj , departementObj);
            System.out.println("\n \n ******************************************* \n Enseignant A été Bien Créer \n ******************************************* \n \n");
            System.out.println(teacherObj);
        }
        do {
            System.out.println("############################### Bienveue A ( " + collegeObj.getNom() + " ) College ############################### \n" +
                               "############################### Vous etes un/une { " + roleName +" } ##############################");
            if( roleId == 1 ) {
                // Create a new Admin
                System.out.println(" 1 ->> Gerer un département \n 2 ->> Gerer un Enseignant \n 3 ->> Gerer un étudiant \n 4 ->> Affichage \n 0 ->> Quittez l'application");
                choosenNum = getChoosenUserInputNumber( 0 , 4 , "le numero" , scanerObj);
            }else if( roleId == 2 ) {
                System.out.println(" 1 ->> Gerer un Enseignant \n 2 ->> Gerer un étudiant \n 3 ->> Affichage \n 0 ->> Quittez l'application");
                choosenNum = getChoosenUserInputNumber( 0 , 3 , "le numero" , scanerObj);
            }else {
                System.out.println(" 1 ->> Affichage \n 0 ->> Quittez l'application");
                choosenNum = getChoosenUserInputNumber( 0 , 1 , "le numero" , scanerObj);
            }
            // Getting the chosen number to decide wich method will be implemented
            switch ( choosenNum ){
                case 1 :
                     if ( roleId == 1 ) {
                         departments = manageDepartement(scanerObj , departments);
                        // if(ReturnedDepartsArr.size() != 0) departments.addAll(ReturnedDepartsArr);
                     }
                     else if ( roleId == 2 ) manageTeacher(scanerObj , teachers);
                     else show(scanerObj);
                break;
                case 2 :
                    if ( roleId == 1 ) manageTeacher(scanerObj , teachers);
                    else  manageStudent(scanerObj);
                break;
                case 3 :
                    if ( roleId == 1 ) manageStudent(scanerObj);
                    else  show(scanerObj);
                break;
                case 4 :
                    show(scanerObj);
            }
        }while (choosenNum != 0) ;
         System.out.println("##################### A Plus Tard Win Academy App ;) ###########################");
    }

    public static ArrayList<Departement> manageDepartement(Scanner scanerObj , ArrayList<Departement> departementsArray){
        // Variables
        int choosenNum = 0 , choice  = 0 , departRepeatOper = 1, departementId , departArraySize , isDepartWilBeDeleted;
        Departement TempObj ;
        String departementName ;
        //ArrayList<Departement> tempArry = new ArrayList<Departement>();

        departArraySize = departementsArray.size();
        TempObj = departementsArray.get(departArraySize - 1) ;
        departementId = TempObj.getId();
        do {
            System.out.println("============================================== Departement Section ==============================================================\n 1 ->> Ajouter un département \n" +
                    " 2 ->> Modifier Un Département \n 3 ->> Supprimer Un Département  \n 4 ->> Afficher Un Ou Plusieurs Départements \n 0 ->> Retour \n");

            choosenNum = getChoosenUserInputNumber( 0 ,  4 , "Le Numero" , scanerObj);
            switch (choosenNum) {
                case 1:
                    // Add New Departement
                    do {
                        System.out.println("\n Veuillez Entrez Les Données Nécessaires Pour Créer Un Nouveau Département ");
                        System.out.print("\n \t |-->> Entrez Le Nom du Département: ");
                        departementName = stringScannerMeth((byte) 0, scanerObj);
                        // Creating a new departement
                        Departement departementObj = new Departement((byte) ++departementId, departementName);
                        // Pushing the departement Obj to the Departement 's Arrays List
                        departementsArray.add(departementObj);
                        //Incrementing the array Size by one
                        departArraySize++;
                        System.out.println("\n ************************ Un Nouveau Département A été Créé Par Succès ******************************* \n");
                        System.out.println("\n Voulez Vous Créér Encore Un Nouveau Département ( 1 -> OUI || 0 -> NON ) : ");
                        departRepeatOper = getChoosenUserInputNumber(0, 1, "0 Ou 1", scanerObj);
                    } while (departRepeatOper == 1);
                    break;
                case 2:
                    // Edit A Certain Departement
                    do {
                        System.out.println("\nListe Des Départements disponible : ");
                        System.out.println(departementsArray);
                        // Pushing the departement Obj to the Departement 's Arrays List
                        departementId = getChoosenUserInputNumber(1, departArraySize, "L'id Du Département à Travers La Liste En Haut Pour Le Modifier", scanerObj);
                        TempObj = departementsArray.get(departementId - 1);
                        System.out.println("\n Veuillez Entrez Les Données Nécessaires Pour Modifier Un Département ");
                        System.out.print("\n \t |-->> Entrez Le Nom du Département: ");
                        departementName = stringScannerMeth((byte) 0, scanerObj);
                        departementsArray.set(departementId - 1 , new Departement(TempObj.getId(), departementName) );
                        System.out.println("\n ************************ Un  Département A été Modifier Par Succès ******************************* \n");
                        System.out.println("\n Voulez Vous Modifier Encore Un  Département ( 1 -> OUI || 0 -> NON ) : ");
                        departRepeatOper = getChoosenUserInputNumber(0, 1, "0 Ou 1", scanerObj);
                    } while (departRepeatOper == 1);
                    break;
                case 3:
                    do {

                        System.out.println("\nListe Des Départements disponible : ");
                        System.out.println(departementsArray);
                        // Pushing the departement Obj to the Departement 's Arrays List
                        departementId = getChoosenUserInputNumber(1, departArraySize, "L'id Du Département à Travers La Liste En Haut Pour Le Supprimer", scanerObj);
                        System.out.println("Vous etes Sur Que vous Voulez Supprimer Le Département Avec l 'id : { " + departementId + " } ( 1 -> OUI || 0 -> NON )");
                        isDepartWilBeDeleted = getChoosenUserInputNumber(0, 1, "0 Ou 1", scanerObj);
                        if ( isDepartWilBeDeleted == 0 ) continue;
                        //Deletin the departement
                        departementsArray.remove(departementId - 1);
                        // Decremeting the size of the Array By one
                        departArraySize--;
                        System.out.println("\n ************************ Un  Département A été Supprimer Par Succès ******************************* \n");
                        System.out.println("\n Voulez Vous Supprimer Encore Un  Département ( 1 -> OUI || 0 -> NON ) : ");
                        departRepeatOper = getChoosenUserInputNumber(0, 1, "0 Ou 1", scanerObj);
                    }while( departRepeatOper == 1 );
                    break;
                case 4:
                    do {
                        choice = getChoosenUserInputNumber(1, 2, "( 1 ) Pour Afficher Tout Les Départements \t || \t ( 2 ) Pour Un Certain Département", scanerObj);
                        if (choice == 1) {
                            System.out.println("Liste Des Tout Les Départements Disponible dans le collège");
                            System.out.println(departementsArray);
                        } else {
                            departementId = getChoosenUserInputNumber(1 , departArraySize , "L'id Du Département Pour L' Afficher" ,scanerObj);
                            TempObj = departementsArray.get(departementId - 1);
                            System.out.println(TempObj);
                        }
                        System.out.println("\n Voulez Vous Encore Afficher  Un Ou Plusieurs Départements ( 1 -> OUI || 0 -> NON ) : ");
                        departRepeatOper = getChoosenUserInputNumber(0, 1, "0 Ou 1", scanerObj);
                    }while( departRepeatOper == 1 );
            }

        }while(choosenNum != 0 );


        return departementsArray ;
    }

    public static void manageTeacher(Scanner scanerObj , ArrayList<Enseignant> teacherArr){

    }

    public static void manageStudent(Scanner scanerObj){}

    public static void show(Scanner scanerObj){}

    public static int getChoosenUserInputNumber(int start , int end , String text , Scanner scanerObj){
        // Defining Variables :
        int choosenNum ;
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

    public static int validateUserInputForNum(Scanner scanerObj){
        // Defining Variable :
        int choosenNumber ;

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

    public static String stringScannerMeth( byte length , Scanner scanerObj){
        // Defining Variable :
        String Text ;
        do {
            Text = scanerObj.nextLine();
            if( Text.length() > length ){
                break;
            }
            System.out.print(" Champ Textuelle Ne Peut Pas être Vide Ou Inférieure à [ "+ ( length + 1 ) +" ] Caractère : ");

        }while(true);

        return Text ;

    }

    public static int numberScannerMeth(int length , Scanner scanerObj){
        int number ;
        do {
            number = scanerObj.nextInt();
            if( String.valueOf(number).length() == length ){
                break;
            }
            System.out.print(" Champ Numérique Ne Peut Pas être Vide Et Doit être égale à [ "+ length +" ] Nombres : ");

        }while(true);

        return number ;
    }

    public static String getDate(Scanner scanerObj){
        int day , month , year ;
        String date ;
        System.out.println(" |-> Veuillez Entrez Votre Date D' entrée  ");
        System.out.println("Entrez Le Jour En ( dd ) : ");
        day = numberScannerMeth(2 , scanerObj);
        System.out.println("Entrez Le Mois En ( mm ) : ");
        month = numberScannerMeth(2 , scanerObj);
        System.out.println("Entrez L' année En ( yyyy ) : ");
        year = numberScannerMeth(4 , scanerObj);
        date = day + " - " + month + " - " + year ;
        return date ;
    }


    public static void loopThroughRoleList(ArrayList<Role> Arr){
        for (Role roleObj : Arr) {
            System.out.print(roleObj);
        }
    }
    public static void loopThroughMatiereList(ArrayList<Matiere> Arr){
        for (Matiere matiereObj : Arr) {
            System.out.print(matiereObj);
        }
    }
    public static void loopThroughDepartementList(ArrayList<Departement> Arr) {
        for (Departement departementObj : Arr) {
            System.out.print(departementObj);
        }
    }
}