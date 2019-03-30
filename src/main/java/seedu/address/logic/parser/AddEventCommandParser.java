package seedu.address.logic.parser;

import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.*;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddEventCommandParser implements Parser<AddEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddEventCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddEventCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_DATE, PREFIX_TIME, PREFIX_VENUE,
                        PREFIX_TARGETAUDIENCE, PREFIX_DRESSCODE, PREFIX_DESCRIPTION);

        if (!arePrefixesPresent(argMultimap, PREFIX_TITLE, PREFIX_DATE, PREFIX_TIME, PREFIX_VENUE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddEventCommand.MESSAGE_USAGE));
        }

        Title title = ParserUtil.parseTitle(argMultimap.getValue(PREFIX_TITLE).get());
        Date date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        Time time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).get());
        Venue venue = ParserUtil.parseVenue(argMultimap.getValue(PREFIX_VENUE).get());
        TargetAudience audience = ParserUtil.parseTargetAudience(argMultimap.getValue(PREFIX_TARGETAUDIENCE).get());
        DressCode code = ParserUtil.parseDressCode(argMultimap.getValue(PREFIX_DRESSCODE).get());
        Description desc = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());

        Event event = new Event(title, venue, date, time, desc, code, audience);

        return new AddEventCommand(event);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
