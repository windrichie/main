package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ACTIVITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ACTIVITY_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ACTIVITY_TIME;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddActivityCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.TimeTable.Activity;
import seedu.address.model.person.TimeTable.Day;
import seedu.address.model.person.TimeTable.StartTime;

public class AddActivityCommandParser {


    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddActivityCommand parse(String args) throws ParseException {

        Index index;

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_ACTIVITY, PREFIX_ACTIVITY_DAY, PREFIX_ACTIVITY_TIME);

        /*if (!arePrefixesPresent(argMultimap, PREFIX_ACTIVITY, PREFIX_ACTIVITY_DAY, PREFIX_ACTIVITY_TIME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddActivityCommand.MESSAGE_USAGE));
        }*/


        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddActivityCommand.MESSAGE_USAGE));
        }

        Activity activity = ParserUtil.parseActivity(argMultimap.getValue(PREFIX_ACTIVITY).get());
        Day day = ParserUtil.parseDay(argMultimap.getValue(PREFIX_ACTIVITY_DAY).get());
        StartTime startTime = ParserUtil.parseStartTime(argMultimap.getValue(PREFIX_ACTIVITY_TIME).get());
        //Set<Module> moduleList = ParserUtil.parseModules(argMultimap.getAllValues(PREFIX_MODULE));


        return new AddActivityCommand(index, activity, day.getDay(), startTime.getStartTime());
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}