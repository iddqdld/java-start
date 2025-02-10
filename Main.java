import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creation de l'objet scanner
        System.out.println("Entrez le couleur de la voiture : ");
        String couleur = sc.nextLine();
        sc.close(); // fermeture du scanner

        boolean found = false;
        for (String color : Car.coloarAutorized) {
            if (color.equals(couleur)) {
                found = true;
                break;
            }
        }
        
        if (found) {
            Car car = new Car("Toyota", "Prado", couleur);
            System.out.println("La voiture est de marque " + car.getMarque() + ", de modele " + car.getModele() + " et de couleur " + car.getCouleur());
        } else {
            System.out.println("La couleur de la voiture n'est pas autorisee");
        }
    }
}