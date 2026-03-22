package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.person.Pet;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPets {

    public static final Pet SNOOPY = new PetBuilder()
            .withName("Snoopy")
            .withSpecies("Dog")
            .withBreed("Labrador")
            .withNote("Very friendly")
            .build();
    public static final Pet DOGGY = new PetBuilder()
            .withName("Doggy")
            .withSpecies("Dog")
            .withBreed("Poodle")
            .withNote("Very cute")
            .build();

    private TypicalPets() {} // prevents instantiation


    public static List<Pet> getTypicalPets() {
        return new ArrayList<>(Arrays.asList(SNOOPY, DOGGY));
    }
}
