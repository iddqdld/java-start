public class Animal {
    protected String type;
    public void sound() {
        System.out.println("Animal sound");
    }

    public class Chat extends Animal {
        public Chat() {
            type = "Cat";
        }

        public void sound() {
            System.out.println("Meow");
        }
    }

    public class Chien extends Animal {
        public Chien() {
            type = "Dog";
        }

        public void sound() {
            System.out.println("Bark");
        }
    }





}

