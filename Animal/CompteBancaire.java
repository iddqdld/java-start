public class CompteBancaire {
    private String titulaire;
    private double solde;

    public CompteBancaire(String titulaire, double montant) {
        this.titulaire = titulaire;
        this.solde = montant;
    }

    public void deposer(double montant) {
        if (montant > 0) {
        this.solde += montant;
        System.out.println(this.titulaire + ": " + montant + "a ete depose sur le compt.");
        System.out.println(solde);
    }
    }

    public void retirer(double montant) {
        if ((this.solde - montant) > 0) {
        this.solde -= montant;
        System.out.println(this.titulaire + ": " + montant + "a ete retire du compte.");
        System.out.println(solde);
    }

    else {
        System.out.println("Solde insuffisant");
    }
    }
}