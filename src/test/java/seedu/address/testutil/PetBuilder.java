package seedu.address.testutil;


import seedu.address.model.person.Name;
import seedu.address.model.person.Pet;

/**
 * A utility class to help with building Person objects.
 */
public class PetBuilder {

    public static final String DEFAULT_NAME = "Snoopy";

    private Name name;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PetBuilder() {
        name = new Name(DEFAULT_NAME);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PetBuilder(Pet petToCopy) {
        name = petToCopy.getName();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PetBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public Pet build() {
        return new Pet(name);
    }
}
