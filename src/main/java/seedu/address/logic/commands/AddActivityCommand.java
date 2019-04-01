package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ACTIVITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ACTIVITY_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ACTIVITY_TIME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Activity;
import seedu.address.model.person.Person;

public class AddActivityCommand extends Command{

    public static final String COMMAND_WORD = "addActivity";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an activity to a person's timetable. "
            + "Parameters:  INDEX (must be a positive integer) "
            + PREFIX_ACTIVITY + "ACTIVITY "
            + PREFIX_ACTIVITY_DAY + "DAY "
            + PREFIX_ACTIVITY_TIME + "START TIME \n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_ACTIVITY + "CS2113 "
            + PREFIX_ACTIVITY_DAY + "0 "
            + PREFIX_ACTIVITY_TIME + "13";


    public static final String MESSAGE_ADD_ACTIVITY_SUCCESS = "A new activity has been added to %1$s 's time table";
    public static final String MESSAGE_DUPLICATE_ACTIVITY = "This activity has already been added";

    private final Activity toAdd;
    private final Index index;
    private final int day;
    private final int startTime;

    /**
     * Creates an AddActivityCommand to add the specified {@code Person}
     */
    public AddActivityCommand(Index index, Activity activity, int day, int startTime) {
        requireNonNull(index);
        requireNonNull(activity);

        this.toAdd = activity;
        this.index = index;
        this.day = day;
        this.startTime = startTime;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException{
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToAddActivity = lastShownList.get(index.getZeroBased());

        Person editedPerson = personWithNewTimeTable(personToAddActivity, toAdd, day, startTime);

        model.setPerson(personToAddActivity, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        model.commitAddressBook();

        return new CommandResult(String.format(MESSAGE_ADD_ACTIVITY_SUCCESS, editedPerson));
    }

    private static Person personWithNewTimeTable(Person personToEdit, Activity toAdd, int day, int startTime) {
        assert personToEdit != null;
        personToEdit.getTimeTable().add(toAdd, day, startTime);

        return new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(), personToEdit.getAddress(), personToEdit.getModule(), personToEdit.getTags(), personToEdit.getTimeTable());
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddActivityCommand // instanceof handles nulls
                && toAdd.equals(((AddActivityCommand) other).toAdd));
    }
}
