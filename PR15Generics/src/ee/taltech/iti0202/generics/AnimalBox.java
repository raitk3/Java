package ee.taltech.iti0202.generics;

import ee.taltech.iti0202.generics.foods.Food;

import java.lang.reflect.Type;
import java.util.Optional;

public class AnimalBox<Animal> {
    private ee.taltech.iti0202.generics.Animal animalInBox;
    private Type type;
    public void put(ee.taltech.iti0202.generics.Animal animal) {
        if (animal != null) {
            animalInBox = animal;
        }
    }

    public void sound() {
        if (this.animalInBox != null) {
            this.animalInBox.sound();
        }
    }

    public void feed(Food food) {
        if (this.animalInBox != null) {
            System.out.println(this.animalInBox.getName() + " was fed with " + food.getName());
        }
    }
    public Optional<Animal> getAnimal() {
        Optional<Animal> returnable = (Optional<Animal>) Optional.ofNullable(this.animalInBox);
        return returnable;
    }

}
