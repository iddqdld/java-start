public class Person {
    private String nom;
    private int age;

    public Person() {
        this.nom = "";
        this.age = 0;
    }

    public Person(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public void sePresenter() {
        System.out.println("Je m'appelle " + this.nom + " et j'ai " + this.age + " ans");
    }
}
