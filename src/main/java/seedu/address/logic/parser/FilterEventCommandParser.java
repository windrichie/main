package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FilterEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.DateEqualsPredicate;

/**
 * Parses input arguments and creates a new FilterEventCommand object
 */
public class FilterEventCommandParser implements Parser<FilterEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterEventCommand
     * and returns an FilterEventCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterEventCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterEventCommand.MESSAGE_USAGE));
        }

        return new FilterEventCommand(new DateEqualsPredicate(trimmedArgs));
    }

}
