package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Module;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Slot;
import seedu.address.model.person.TimeSlot;
import seedu.address.model.tag.Tag;

public class CheckAvailabilityCommand extends Command {

    public static final String COMMAND_WORD = "checkAvail";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Checks the available meeting times between 2 students. "
            + "Parameters: "
            + ": Checks the availability of the people indentified by the indexes in the list.\n"
            + "Parameters: INDEX1 INDEX2(Both indexes must be positive integers)\n"
            + "Example: " + COMMAND_WORD + " 1 2 ";


    public static final String MESSAGE_SUCCESS = "The available times are : $s";
    public static final String MESSAGE_NO_TIMES_AVAILABLE = "There are no meeting times available between these two people";

    private final Index personOneIndex;
    private final Index personTwoIndex;
    /**
     * Creates a CheckAvailabilityCommand to check the avalabilities betwene person1 and person 2 {@code Person}
     */

    public CheckAvailabilityCommand(Index personOneIndex, Index personTwoIndex) {
        this.personOneIndex = personOneIndex;
        this.personTwoIndex = personTwoIndex;
    }



    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if ((personOneIndex.getZeroBased()  >= lastShownList.size()) || (personTwoIndex.getZeroBased()  >= lastShownList.size())) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personOne = lastShownList.get(personOneIndex.getZeroBased());
        Person personTwo = lastShownList.get(personTwoIndex.getZeroBased());

        TimeSlot availableTimes = getAvailabilities(personOne, personTwo);

        //model.setPerson(personToEdit, editedPerson);
        return new CommandResult(String.format(MESSAGE_SUCCESS, availableTimes));
    }

    /**
     * Creates and returns a {@code TimeSlot} with the details of availabilities between {@code personOne}
     * and {@code personTwo}
     */
    private static TimeSlot getAvailabilities(Person personOne, Person personTwo) {

        Slot slotOne = personOne.getTimeSlot();
        Slot slotTwo = personTwo.getTimeSlot();

        TimeSlot availableTimes = new TimeSlot();

        for(int i = 0; i < slotOne.length; i++) {
            if (slotOne[i] == null && slotTwo[i] == null) {
                availableTimes.add(slotOne[i]);
            }
        }

        return availableTimes;
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CheckAvailabilityCommand// instanceof handles nulls
                && personOneIndex.equals(((CheckAvailabilityCommand) other).personOneIndex)); // state check
    }
}


}
