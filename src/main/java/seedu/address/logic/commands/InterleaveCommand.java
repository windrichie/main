package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Interleaves the self study hours of {@code model}'s scheduler.
 */
public class InterleaveCommand extends Command {

    public static final String COMMAND_WORD = "interleave";
    public static final String MESSAGE_SUCCESS = "Interleave success!";

    private final Index index;
    private final EditPersonDescriptor editPersonDescriptor;

    /**
     * Creates an InterleaveCommand to add the specified {@code Person}
     */
    public InterleaveCommand(Index index) {
        requireNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);
        List<Person> personList = model.getFilteredPersonList(); //Filter doesnt mean anything

        if (index.getZeroBased() >= personList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToInterleave = personList.get(index.getZeroBased());
        /*  if (!interleave) {
            throw new CommandException(MESSAGE_FAILURE);
        }*/

        model.interleave();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
