package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DRESSCODE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TARGETAUDIENCE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VENUE;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Date;
import seedu.address.model.event.Description;
import seedu.address.model.event.DressCode;
import seedu.address.model.event.Event;
import seedu.address.model.event.TargetAudience;
import seedu.address.model.event.Time;
import seedu.address.model.event.Title;
import seedu.address.model.event.Venue;

//@@author windrichie
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
        TargetAudience audience = new TargetAudience("");
        DressCode code = new DressCode("");
        Description desc = new Description("");
        if (argMultimap.getValue(PREFIX_TARGETAUDIENCE).isPresent()) { // check if user inputs any target audience
            audience = ParserUtil.parseTargetAudience(argMultimap.getValue(PREFIX_TARGETAUDIENCE).get());
        }
        if (argMultimap.getValue(PREFIX_DRESSCODE).isPresent()) { // check if user inputs any dress code
            code = ParserUtil.parseDressCode(argMultimap.getValue(PREFIX_DRESSCODE).get());
        }
        if (argMultimap.getValue(PREFIX_DESCRIPTION).isPresent()) { // check if user inputs any description
            desc = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());
        }

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
