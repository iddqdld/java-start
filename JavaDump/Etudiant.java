public class Etudiant {
    private String nom;
    private int age;

    public Etudiant(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return this.nom;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return "Nom: " + this.nom + ", Age: " + this.age;
    }
}