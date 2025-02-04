import java.util.Scanner;

public class ask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("How old are you? ");
        int age = scanner.nextInt();
        
        scanner.close();
        
        System.out.println("Hello, " + name + "! Vous avez " + age + " ans.");

        if (age < 18) {
            System.out.println("You are a minor.");
        } else {
            System.out.println("You are an adult.");
        }
        
           
    }
}
