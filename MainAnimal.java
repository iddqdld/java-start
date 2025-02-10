public class MainAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal.Chat chat = animal.new Chat();
        Animal.Chien chien = animal.new Chien();
        chat.sound();
        chien.sound();
    }
}