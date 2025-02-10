public class Car {
    private String marque;
    private String modele;
    private String couleur;

    public String[] coloarAutorized = {"rouge", "bleu", "vert"};

    public Car(String marque, String modele, String couleur) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
    }

    public String getMarque() {
        return this.marque;
    }

    public String getModele() {
        return this.modele;
    }

    public String getCouleur() {
        return this.couleur;
    }

    void demarrer() {
        System.out.println("La voiture demarre");
    }

    void accelerer() {
        System.out.println("La voiture accelere");
    }

    void freiner() {
        System.out.println("La voiture freine");
    }
}
