package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DRESSCODE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TARGETAUDIENCE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VENUE;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;

//@@author windrichie
/**
 * Adds an event to the event calendar.
 */
public class AddEventCommand extends Command {

    public static final String COMMAND_WORD = "addevent";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an event to the event calendar. "
            + "Parameters: "
            + PREFIX_TITLE + "TITLE "
            + PREFIX_DATE + "DATE "
            + PREFIX_TIME + "TIME "
            + PREFIX_VENUE + "VENUE "
            + "[" + PREFIX_TARGETAUDIENCE + "AUDIENCE] "
            + "[" + PREFIX_DRESSCODE + "DRESSCODE] "
            + "[" + PREFIX_DESCRIPTION + "DESCRIPTION]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "UBS - Unlock Your Potential with us "
            + PREFIX_DATE + "01/04/2019 "
            + PREFIX_TIME + "15:00-16:00 "
            + PREFIX_VENUE + "UBS Office "
            + "[" + PREFIX_TARGETAUDIENCE + "All Year 1 female students] "
            + "[" + PREFIX_DRESSCODE + "Business Formal] "
            + "[" + PREFIX_DESCRIPTION + "Unlock Your Potential with us.]...\n";

    public static final String MESSAGE_SUCCESS = "New event added: %1$s";
    public static final String MESSAGE_DUPLICATE_EVENT = "This event already exists in the events calendar";

    private final Event toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddEventCommand(Event event) {
        requireNonNull(event);
        toAdd = event;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (model.hasEvent(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_EVENT);
        }

        model.addEvent(toAdd);
        // model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddEventCommand // instanceof handles nulls
                && toAdd.equals(((AddEventCommand) other).toAdd));
    }

}
