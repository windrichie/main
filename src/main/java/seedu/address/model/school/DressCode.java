package seedu.address.model.school;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Event's dress code in the school calendar of events.
 * Guarantees: immutable; is valid as declared in {@link #isValidDressCode(String)}
 */
public class DressCode {

    public static final String MESSAGE_CONSTRAINTS =
            "Dress Code should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the dress code must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String dressCode;

    /**
     * Constructs a {@code DressCode}.
     *
     * @param dresscode A valid dress code.
     */
    public DressCode(String dresscode) {
        requireNonNull(dresscode);
        checkArgument(isValidDressCode(dresscode), MESSAGE_CONSTRAINTS);
        dressCode = dresscode;
    }

    /**
     * Returns true if a given string is a valid dress code.
     */
    public static boolean isValidDressCode(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return dressCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short  if same object
                || (other instanceof DressCode // instanceof handles nulls
                && dressCode.equals(((DressCode) other).dressCode)); // state check
    }

    @Override
    public int hashCode() {
        return dressCode.hashCode();
    }

}
