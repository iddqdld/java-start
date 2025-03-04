package com.monprojet;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    
    
    System.out.println( "Hello World!" );
    Connexion link = new Connexion();
    GestionUtilisateurs GestionUtilisateurs = new GestionUtilisateurs(link);

    Scanner sc = new Scanner(System.in);
    int choice = 0;
    
    do {
        System.out.println("Menu :");
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Lister les utilisateurs");
        System.out.println("3. Quitter");
        
        choice = sc.nextInt();
        sc.nextLine(); // Clear the buffer
        
        switch (choice) {
            case 1:
                System.out.println("Ajout d'un utilisateur :");
                System.out.println("Entrez le nom de l'utilisateur :");
                String nom = sc.nextLine();
                System.out.println("Entrez l'email de l'utilisateur :");
                String email = sc.nextLine();
                GestionUtilisateurs.addUser(nom, email);
                break;
            case 2:
                System.out.println("Liste des utilisateurs :");
                GestionUtilisateurs.listUtilisateur();
                break;
            case 3:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Option invalide !");
                break;
        }
    } while (choice != 3);
    System.out.println("END");
    }
}
