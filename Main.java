public class Main {
    public static void main(String[] args) {
        Car toyota = new Car("toyota", "corolla", "rouge");
        System.out.println(toyota.getMarque() + " " + toyota.getModele() + " " + toyota.getCouleur());

        for (String color : toyota.coloarAutorized) {
            System.out.println(color);
        }
    }
}