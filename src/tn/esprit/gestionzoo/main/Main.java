package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Food;
import tn.esprit.gestionzoo.entities.InvalidAgeException;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.ZooFullException;

public class Main {

    private static void addAndDisplay(Zoo zoo, Animal animal) {
        try {
            zoo.addAnimal(animal);
        } catch (ZooFullException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Number of animals in " + zoo.getName() + ": " + zoo.getAnimalCount());
        }
    }

    public static void main(String[] args) {
        try {
            Animal lion = new Animal();
            lion.setFamily("Felidae");
            lion.setName("Simba");
            lion.setAge(5);
            lion.setMammal(true);

            Zoo myZoo = new Zoo();
            myZoo.setName("Belvedere");
            myZoo.setCity("Tunis");

            Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
            Zoo zoo2 = new Zoo("Friguia", "Hammamet");

            myZoo.displayZoo();
            System.out.println(myZoo);
            System.out.println(myZoo.toString());
            System.out.println(lion);

            addAndDisplay(myZoo, lion);
            addAndDisplay(myZoo, tiger);

            myZoo.displayAnimals();
            System.out.println(myZoo.searchAnimal(lion));
            Animal lionCopy = new Animal("Felidae", "Simba", 5, true);
            System.out.println(myZoo.searchAnimal(lionCopy));

            addAndDisplay(myZoo, lionCopy);
            for (int i = 1; i <= 5; i++) {
                addAndDisplay(myZoo, new Animal("Family" + i, "Animal" + i, i, true));
            }
            System.out.println(myZoo.getAnimalCount());

            System.out.println(myZoo.removeAnimal(tiger));

            System.out.println(myZoo.isZooFull());

            addAndDisplay(zoo2, tiger);
            System.out.println(Zoo.compareZoo(myZoo, zoo2).getName());

            Terrestrial terrestrial = new Terrestrial();
            Dolphin dolphin = new Dolphin();
            Penguin penguin = new Penguin();

            Terrestrial terrestrial2 = new Terrestrial("Canidae", "Rex", 4, true, 4);
            Dolphin dolphin2 = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
            Penguin penguin2 = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);

            System.out.println(terrestrial2);
            System.out.println(dolphin2);
            System.out.println(penguin2);

            dolphin2.swim();
            penguin2.swim();

            Dolphin dolphin3 = new Dolphin("Delphinidae", "Dory", 6, true, "Ocean", 40.0f);
            Penguin penguin3 = new Penguin("Spheniscidae", "Skipper", 5, false, "Antarctica", 200.0f);
            myZoo.addAquaticAnimal(dolphin2);
            myZoo.addAquaticAnimal(penguin2);
            myZoo.addAquaticAnimal(dolphin3);
            myZoo.addAquaticAnimal(penguin3);

            System.out.println("--- All aquatic animals swim ---");
            for (int i = 0; i < myZoo.getAquaticCount(); i++) {
                myZoo.getAquaticAnimals()[i].swim();
            }

            System.out.println("Max penguin swimming depth: " + myZoo.maxPenguinSwimmingDepth());

            myZoo.displayNumberOfAquaticsByType();

            Dolphin dolphinTwin = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 50.0f);
            System.out.println(dolphin2.equals(dolphinTwin)); // true: same name, age, habitat
            System.out.println(dolphin2.equals(dolphin3));    // false: different name and age
            System.out.println(dolphin2.equals(penguin2));    // false

            System.out.println("--- Instruction 38: eating ---");
            Aquatic aquatic = new Dolphin("Delphinidae", "Delphy", 10, true, "Ocean", 30.0f);
            aquatic.eatMeat(Food.MEAT);
            aquatic.eatMeat(Food.PLANT);

            penguin2.eatMeat(Food.MEAT);

            terrestrial2.eatMeat(Food.MEAT);
            terrestrial2.eatPlant(Food.PLANT);
            terrestrial2.eatPlant(Food.MEAT);
            terrestrial2.eatPlantAndMeet(Food.BOTH);
            terrestrial2.eatPlantAndMeet(Food.MEAT);

            System.out.println("--- Negative age test ---");
            lion.setAge(-3);
            System.out.println("This line is never reached");
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        }

        try {
            new Zoo().setName("");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}