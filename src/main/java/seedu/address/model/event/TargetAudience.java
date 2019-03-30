package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Event's target audience in the event calendar of events.
 * Guarantees: immutable; is valid as declared in {@link #isValidTargetAudience(String)}
 */
public class TargetAudience {

    public static final String MESSAGE_CONSTRAINTS =
            "Target audience should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the target audience must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String targetAudience;

    /**
     * Constructs a {@code DressCode}.
     *
     * @param audience A valid dress code.
     */
    public TargetAudience(String audience) {
        requireNonNull(audience);
        checkArgument(isValidTargetAudience(audience), MESSAGE_CONSTRAINTS);
        targetAudience = audience;
    }

    /**
     * Returns true if a given string is a valid target audience.
     */
    public static boolean isValidTargetAudience(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return targetAudience;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short  if same object
                || (other instanceof TargetAudience // instanceof handles nulls
                && targetAudience.equals(((TargetAudience) other).targetAudience)); // state check
    }

    @Override
    public int hashCode() {
        return targetAudience.hashCode();
    }

}
