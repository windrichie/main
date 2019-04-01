package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Interleaves the self study hours of {@code model}'s scheduler.
 */
public class InterleaveCommand extends Command {

    public static final String COMMAND_WORD = "interleave";
    public static final String MESSAGE_SUCCESS = "Interleave success!";

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

      /*  if (!model.canRedoAddressBook()) {
            throw new CommandException(MESSAGE_FAILURE);
        }*/

        model.interleave();
        //model.update;
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
