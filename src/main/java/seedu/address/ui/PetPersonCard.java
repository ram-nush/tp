package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.person.Pet;

/**
 * A UI component that displays information of a {@code Person} on the right,
 * and all their {@code Pet}s on the left.
 */
public class PetPersonCard extends UiPart<Region> {

    private static final String FXML = "PetPersonCard.fxml";
    private final Logger logger = LogsCenter.getLogger(getClass());

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    private final Person person;

    @FXML
    private GridPane petPersonCardPane;

    @FXML
    private VBox petsContainer;

    /**
     * Creates a {@code PetPersonCard} with the given {@code Person}.
     */
    public PetPersonCard(Person person, int personIndex, int startingPetIndex) {
        super(FXML);
        this.person = person;

        PersonCard personCard = new PersonCard(person, personIndex);
        Region personNode = personCard.getRoot();

        if (person.getPets().isEmpty()) {
            logger.info("Client with index " + personIndex + " has no pets");
            Label emptyPetListLabel = new Label("The client has no pets yet");
            emptyPetListLabel.getStyleClass().add("empty_pet_list_label");
            petsContainer.getChildren().add(emptyPetListLabel);
            petsContainer.getStyleClass().add("empty_pet_list_container");
        } else {
            int currentPetIndex = startingPetIndex;
            for (Pet pet : person.getPets()) {
                logger.fine("Showing pet with index " + currentPetIndex
                        + " owned by Client with index " + personIndex);
                PetCard petCard = new PetCard(pet, currentPetIndex);
                petsContainer.getChildren().add(petCard.getRoot());
                currentPetIndex++;
            }
        }

        GridPane.setColumnIndex(petsContainer, 0);
        GridPane.setColumnIndex(personNode, 1);

        petPersonCardPane.getChildren().add(personNode);
    }
}
