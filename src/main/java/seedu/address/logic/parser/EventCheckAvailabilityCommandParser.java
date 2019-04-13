package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddActivityCommand;
import seedu.address.logic.commands.CheckAvailabilityCommand;
import seedu.address.logic.commands.EventCheckAvailabilityCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.timetable.Activity;
import seedu.address.model.person.timetable.Day;
import seedu.address.model.person.timetable.StartTime;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;


/**
 * Parses input arguments and creates a new EventCheckAvailabilityCommand object
 */
public class EventCheckAvailabilityCommandParser {


    /**
     * Parses the given {@code String} of arguments in the context of the EventCheckAvailabilityCommand
     * and returns an EventCheckAvailabilityCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EventCheckAvailabilityCommand parse(String args) throws ParseException {

        Index index;

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_PERSON, PREFIX_EVENT);
        if (!arePrefixesPresent(argMultimap, PREFIX_PERSON, PREFIX_EVENT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    CheckAvailabilityCommand.MESSAGE_USAGE));
        }
//        try {
//            index = ParserUtil.parseIndex(argMultimap.getPreamble());
//        } catch (ParseException pe) {
//            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
//                    EventCheckAvailabilityCommand.MESSAGE_USAGE));
//        }

        Index personIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_PERSON).get());
        Index eventIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_EVENT).get());

        return new EventCheckAvailabilityCommand(personIndex, eventIndex);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
