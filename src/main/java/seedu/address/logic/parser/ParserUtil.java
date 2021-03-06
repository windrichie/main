package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Date;
import seedu.address.model.event.Description;
import seedu.address.model.event.DressCode;
import seedu.address.model.event.TargetAudience;
import seedu.address.model.event.Time;
import seedu.address.model.event.Title;
import seedu.address.model.event.Venue;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.modulelist.Module;
import seedu.address.model.person.modulelist.ModuleList;
import seedu.address.model.person.timetable.Activity;
import seedu.address.model.person.timetable.Day;
import seedu.address.model.person.timetable.StartTime;
import seedu.address.model.person.timetable.TimeTable;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String activity} into a {@code Activity}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code activity} is invalid.
     */
    public static Activity parseActivity(String activity) throws ParseException {
        requireNonNull(activity);
        String trimmedActivity = activity.trim();
        if (!Activity.isValidActivity(trimmedActivity)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Activity(activity);
    }

    /**
     * Parses a {@code String day} into a {@code Day}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code day} is invalid.
     */
    public static Day parseDay(String day) throws ParseException {
        requireNonNull(day);
        String trimmedActivity = day.trim();
        if (!Day.isValidDay(trimmedActivity)) {
            throw new ParseException(Day.MESSAGE_CONSTRAINTS);
        }
        return new Day(day);
    }

    /**
     * Parses a {@code String startTime} into a {@code StartTime}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code startTime} is invalid.
     */
    public static StartTime parseStartTime(String startTime) throws ParseException {
        requireNonNull(startTime);
        String trimmedActivity = startTime.trim();
        if (!StartTime.isValidStartTime(trimmedActivity)) {
            throw new ParseException(StartTime.MESSAGE_CONSTRAINTS);
        }
        return new StartTime(startTime);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }


    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Module parseModule(String module) throws ParseException {
        requireNonNull(module);
        String trimmedModule = module.trim();
        if (!Module.isValidModule(trimmedModule)) {
            throw new ParseException(Module.MESSAGE_CONSTRAINTS);
        }
        return new Module(trimmedModule);
    }

    /**
     * Parses {@code Collection<String> modules} into a {@code Set<modulelist>}.
     */
    public static ModuleList parseModules(Collection<String> modules) throws ParseException {
        requireNonNull(modules);
        final ModuleList moduleSet = new ModuleList();
        for (String module : modules) {
            moduleSet.add(parseModule(module));
        }
        return moduleSet;
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses {@code String day}, {@code String time}, {@code String activity}
     * into a {@code TimeTable}.
     *
     * @throws ParseException if the given parameters is invalid.
     */
    public static TimeTable parseTimetable(String day, String time, String activity) throws ParseException {
        requireNonNull(day);
        requireNonNull(time);
        requireNonNull(activity);
        final TimeTable table = new TimeTable();
        table.add(new Activity(activity), Integer.parseInt(day), Integer.parseInt(time));
        return table;
    }

    //@@author windrichie
    // Parsers for EVENTS
    /**
     * Parses a {@code String title} into a {@code Title}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code title} is invalid.
     */
    public static Title parseTitle(String title) throws ParseException {
        requireNonNull(title);
        String trimmedTitle = title.trim();
        if (!Title.isValidTitle(trimmedTitle)) {
            throw new ParseException(Title.MESSAGE_CONSTRAINTS);
        }
        return new Title(trimmedTitle);
    }

    /**
     * Parses a {@code String date} into a {@code Date}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code title} is invalid.
     */
    public static Date parseDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        if (!Date.isValidDate(trimmedDate)) {
            throw new ParseException(Date.MESSAGE_CONSTRAINTS);
        }
        return new Date(trimmedDate);
    }

    /**
     * Parses a {@code String time} into a {@code Time}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code time} is invalid.
     */
    public static Time parseTime(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        String[] times = trimmedTime.split("-");
        if (times.length != 2) {
            throw new ParseException(Time.MESSAGE_END_TIME_MISSING);
        }
        String trimmedStartTime = times[0];
        String trimmedEndTime = times[1];
        if ((!Time.isValidTime(trimmedStartTime)) || (!Time.isValidTime(trimmedEndTime))) {
            throw new ParseException(Time.MESSAGE_CONSTRAINTS);
        }
        return new Time(trimmedStartTime, trimmedEndTime);
    }

    /**
     * Parses a {@code String venue} into a {@code Venue}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code venue} is invalid.
     */
    public static Venue parseVenue(String venue) throws ParseException {
        requireNonNull(venue);
        String trimmedVenue = venue.trim();
        if (!Venue.isValidVenue(trimmedVenue)) {
            throw new ParseException(Venue.MESSAGE_CONSTRAINTS);
        }
        return new Venue(trimmedVenue);
    }

    /**
     * Parses a {@code String audience} into a {@code TargetAudience}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code audience} is invalid.
     */
    public static TargetAudience parseTargetAudience(String audience) throws ParseException {
        requireNonNull(audience);
        String trimmedTargetAudience = audience.trim();
        if (!TargetAudience.isValidTargetAudience(trimmedTargetAudience)) {
            throw new ParseException(TargetAudience.MESSAGE_CONSTRAINTS);
        }
        return new TargetAudience(trimmedTargetAudience);
    }

    /**
     * Parses a {@code String code} into a {@code DressCode}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code code} is invalid.
     */
    public static DressCode parseDressCode(String code) throws ParseException {
        requireNonNull(code);
        String trimmedDressCode = code.trim();
        if (!DressCode.isValidDressCode(trimmedDressCode)) {
            throw new ParseException(DressCode.MESSAGE_CONSTRAINTS);
        }
        return new DressCode(trimmedDressCode);
    }

    /**
     * Parses a {@code String desc} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code desc} is invalid.
     */
    public static Description parseDescription(String desc) throws ParseException {
        requireNonNull(desc);
        String trimmedDescription = desc.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }
}
