package ee.taltech.iti0202.shelter.shelter;
import ee.taltech.iti0202.shelter.animal.Animal;
import ee.taltech.iti0202.shelter.animalprovider.AnimalProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnimalShelter {
    private Set<Animal> animals;
    private AnimalProvider animalProvider;
    public AnimalShelter(AnimalProvider animalProvider) {
        this.animalProvider = animalProvider;
    }

    /**
     * Gets a list of up to {@code count} animals with the given {@code type} and {@code color}.
     * This method should use animal provider which is set in constructor.
     * As the provider only can filter by type, you have to filter by color yourself.
     * Also, the number of results from provider is not defined, you have to call the provider
     * multiple time to get all the result (but not more than required).
     * The result should come in the order provided by the provider.
     * Also, provider can return duplicate animals. You should return only unique animals.
     * If the provider returns an empty list, stop calling it
     * and return whatever you have by that point.
     * See {@link AnimalProvider#provide(Animal.Type)}.
     *
     * @param animalType Type, see {@link Animal.Type}.
     * @param color Color used when filtering.
     * @param count Maximum number of result to return.
     * @return Maximum {@code count} number of animals with the given type and color.
     */
    public List<Animal> getAnimals(Animal.Type animalType, String color, int count) {
        List<Animal> animals = new ArrayList<>();
        do {
            List<Animal> providedAnimals = animalProvider.provide(animalType);
            for (Animal animal : providedAnimals) {
                if (animal.getColor().equals(color) && animals.size() < count && !animals.contains(animal)) {
                    animals.add(animal);
                }
                if (animals.size() == count) break;
            }
            if (providedAnimals.size() == 0 || animals.size() == count) break;
        } while (true);
        return animals;
    }
}
