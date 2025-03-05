import java.util.Scanner;  
import java.util.ArrayList;

public class MainEtudiant {
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    public void Menu() {
        int choix = 0; 
        Scanner sc = new Scanner(System.in);       
        do {
        
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Voir le liste des etudiants");
        System.out.println("2. Ajouter un etudiant");
        System.out.println("3. Supprimer un etudiant");
        System.out.println("4. Quitter");
        choix = sc.nextInt();
        System.out.println("Vous avez choisi : " + choix);

        switch(choix) {
            case 1:
            System.out.println("Liste des etudiants :");
            break;
            case 2:
            System.out.println("Ajouter un etudiant :");
            break;
            case 3:
            System.out.println("Supprimer un etudiant :");
            break;
        }
        
        } while (choix != 0);

        sc.close();
    
    }

    public static void main(String[] args) {
        System.out.println("Demarrage de l'application");
    }


}