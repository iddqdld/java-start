import java.util.Arrays;

public class table {
    public static void main(String[] args) {
        int[] tableau = {5, 3, 1, 4, 5, 14, 11, 13, 12, 10};

        double sum = 0;
        for (int i = 0; i < tableau.length; i++) {
            sum += tableau[i];
        }
        double moyenne = sum / tableau.length;
        System.out.println("La moyenne est " + moyenne);

        Arrays.sort(tableau);
        System.out.println("Le minimum est " + tableau[0]);

        System.out.println("Le maximum est " + tableau[tableau.length - 1]);

        double median;
        if (tableau.length % 2 == 0) {
            median = (tableau[tableau.length / 2] + tableau[tableau.length / 2 - 1]) / 2.0;
        } else {
            median = tableau[tableau.length / 2];
        }
        System.out.println("La mediane est " + median);

        double ecartType = 0;
        for (int i = 0; i < tableau.length; i++) {
            ecartType += Math.pow(tableau[i] - moyenne, 2);
        }
        ecartType = Math.sqrt(ecartType / tableau.length);
        System.out.println("L'ecart type est " + ecartType);
        

    }
}
