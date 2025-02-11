public class MainBank {
    public static void main(String[] args) {
        CompteBancaire c1 = new CompteBancaire("Jean", 1000);
        c1.deposer(500);
        c1.retirer(2000);
        c1.deposer(501);
        c1.retirer(2000);
    }
}
