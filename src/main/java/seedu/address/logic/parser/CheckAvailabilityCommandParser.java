package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CheckAvailabilityCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class CheckAvailabilityCommandParser implements Parser<CheckAvailabilityCommand> {


    /**
     * Parses the given {@code String} of arguments in the context of the CheckAvailabilityCommand
     * and returns a CheckAvailabilityCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public CheckAvailabilityCommand parse(String args) throws ParseException {

        String trimmedArgs = args.trim();
        String[] indexKeywords = trimmedArgs.split("\\s+");
        Index indexOne = ParserUtil.parseIndex(indexKeywords[0]);
        Index indexTwo = ParserUtil.parseIndex(indexKeywords[1]);

        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, CheckAvailabilityCommand.MESSAGE_USAGE));
        }


        return new CheckAvailabilityCommand(indexOne, indexTwo);
    }

}
