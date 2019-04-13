package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ListActivityCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ListActivityCommand object
 */
public class ListActivityCommandParser implements Parser<ListActivityCommand> {

    public final String VALIDATION_REGEX = "\\d+";

    /**
     * Parses the given {@code String} of arguments in the context of the SelectCommand
     * and returns an SelectCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListActivityCommand parse(String args) throws ParseException {
        if (args.trim().equals("") | args.trim().equals("0") | !args.trim().matches(VALIDATION_REGEX)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ListActivityCommand.MESSAGE_USAGE));
        }
        int index = Integer.valueOf(args.trim());
        return new ListActivityCommand(index - 1);
    }
}
