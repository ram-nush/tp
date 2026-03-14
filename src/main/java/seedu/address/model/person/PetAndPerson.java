package seedu.address.model.person;

/**
 * Represents a Pet and Person in the address book.
 * Guarantees: immutable;
 */
public class PetAndPerson {
    private final Pet pet;
    private final Person person;

    /**
     * Constructs a {@code PetAndPerson}.
     *
     * @param pet A valid Pet object.
     * @param person A valid Person object.
     */
    public PetAndPerson(Pet pet, Person person) {
        this.pet = pet;
        this.person = person;
    }

    public Pet getPet() {
        return pet;
    }

    public Person getPerson() {
        return person;
    }
}
