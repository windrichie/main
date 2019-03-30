package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Event's start and end time in the event calendar of events.
 * Guarantees: immutable; is valid as declared in {@link #isValidTime(String)}
 */
public class Time {

    public static final String MESSAGE_CONSTRAINTS =
            "Time should be in HH:MM format, ranging from 00:00 to 23:59";
    public static final String VALIDATION_REGEX = "^([0-1][0-9]|[2][0-3]):([0-5][0-9])$";
    public final String startTime;
    public final String endTime;

    /**
     * Constructs a {@code Time}.
     *
     * @param starttime A valid start time.
     * @param endtime A valid end time.
     */
    public Time(String starttime, String endtime) {
        requireNonNull(starttime);
        requireNonNull(endtime);
        checkArgument(isValidTime(starttime), MESSAGE_CONSTRAINTS);
        checkArgument(isValidTime(endtime), MESSAGE_CONSTRAINTS);
        startTime = starttime;
        endTime = endtime;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidTime(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String startTimeToString() {
        return startTime;
    }

    public String endTimeToString() {
        return endTime;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Time // instanceof handles nulls
                && startTime.equals(((Time) other).startTime)); // state check
    }

    public int startTimeHashCode() {
        return startTime.hashCode();
    }

    public int endTimeHashCode() {
        return endTime.hashCode();
    }

}
