public class Produit {
    protected double prix;

    public void calculerPrix(double prix) {
        
    }

    public class Livre extends Produit {
        public Livre() {
            prix = 10.0;
        }

        public void calculerPrix(double prix) {
            System.out.println("Le prix du livre est de " + prix * 1.05 + " euros");
        }
    }

    public class DVD extends Produit {
        public DVD() {
            prix = 15.0;
        }

        public void calculerPrix(double prix) {
            System.out.println("Le prix du DVD est de " + prix * 1.20 + " euros");
        }
    }
    
}