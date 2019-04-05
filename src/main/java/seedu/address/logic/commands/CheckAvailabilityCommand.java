package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.timetable.TimeTable;

/**
 * Checks the availability between 2 people in the application.
 */
public class CheckAvailabilityCommand extends Command {

    public static final String COMMAND_WORD = "checkAvail";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Checks the available meeting times"
            + " between 2 students."
            + "Parameters: "
            + ": Checks the availability of the people indentified by the indexes in the list.\n"
            + "Parameters: INDEX1 INDEX2(Both indexes must be positive integers)\n"
            + "Example: " + COMMAND_WORD + " 1 2 ";


    public static final String MESSAGE_SUCCESS = "The available times are : $s";
    public static final String MESSAGE_NO_TIMES_AVAILABLE = "There are no meeting times available between"
            + " these two people";

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

        if ((personOneIndex.getZeroBased() >= lastShownList.size())
           || (personTwoIndex.getZeroBased() >= lastShownList.size())) {
           throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personOne = lastShownList.get(personOneIndex.getZeroBased());
        Person personTwo = lastShownList.get(personTwoIndex.getZeroBased());

        ArrayList<String> availableTimes = getAvailabilities(personOne, personTwo);

        return new CommandResult(String.format(MESSAGE_SUCCESS, availableTimes));
    }

    /**
     * Creates and returns a {@code TimeSlot} with the details of availabilities between {@code personOne}
     * and {@code personTwo}
     */
    private static ArrayList<String> getAvailabilities(Person personOne, Person personTwo) {

        TimeTable timeTableOne = personOne.getTimeTable();
        TimeTable timeTableTwo = personTwo.getTimeTable();

        String[][] activitiesOne = timeTableOne.getTimeTableArray();
        String[][] activitiesTwo = timeTableTwo.getTimeTableArray();

        ArrayList<String> availableTimes = new ArrayList<String>();


        for (int i = 0; i < activitiesOne.length; i++) {
            for (int j = 0; j < activitiesOne[0].length; j++) {
                if (activitiesOne[i][j] == null && activitiesTwo[i][j] == null) {
                    availableTimes.add("Day is " + i + " Hour is " + j);
                }
            }
        }

        return availableTimes;
    }

}



