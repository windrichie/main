package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Event's venue in the event calendar of events.
 * Guarantees: immutable; is valid as declared in {@link #isValidVenue(String)}
 */
public class Venue {

    public static final String MESSAGE_CONSTRAINTS =
            "Venues should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the venue must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String eventVenue;

    /**
     * Constructs a {@code Venue}.
     *
     * @param venue A valid venue.
     */
    public Venue(String venue) {
        requireNonNull(venue);
        checkArgument(isValidVenue(venue), MESSAGE_CONSTRAINTS);
        eventVenue = venue;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidVenue(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return eventVenue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short  if same object
                || (other instanceof Venue // instanceof handles nulls
                && eventVenue.equals(((Venue) other).eventVenue)); // state check
    }

    @Override
    public int hashCode() {
        return eventVenue.hashCode();
    }

}
