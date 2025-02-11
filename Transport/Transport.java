public interface Transport {
    public void deplacer();

    public class Voiture implements Transport {
        public void deplacer() {
            System.out.println("Je roule en voiture");
        }
    }

    public class Avion implements Transport {
        public void deplacer() {
            System.out.println("Je vole en avion");
        }
    }

    public static void main(String[] args) {
        Voiture v = new Voiture();
        Avion a = new Avion();
        v.deplacer();
        a.deplacer();
    }
}

