package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal implements Omnivore<Food> {
    private int nbrLegs;

    public Terrestrial() {
    }

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs)
            throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return "Terrestrial [" + super.toString() + ", nbrLegs=" + nbrLegs + "]";
    }

    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT) {
            System.out.println("This terrestrial animal is eating meat");
        } else {
            System.out.println("eatMeat expects MEAT, not " + meat);
        }
    }

    @Override
    public void eatPlant(Food plant) {
        if (plant == Food.PLANT) {
            System.out.println("This terrestrial animal is eating plants");
        } else {
            System.out.println("eatPlant expects PLANT, not " + plant);
        }
    }

    @Override
    public void eatPlantAndMeet(Food food) {
        if (food == Food.BOTH) {
            System.out.println("This terrestrial animal is eating plants and meat");
        } else {
            System.out.println("eatPlantAndMeet expects BOTH, not " + food);
        }
    }
}