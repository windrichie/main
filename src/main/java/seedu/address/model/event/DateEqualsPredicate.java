package seedu.address.model.event;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.person.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Event}'s {@code date} matches the date of the event.
 */
public class DateEqualsPredicate implements Predicate<Event> {
    private final String keywords;

    public DateEqualsPredicate(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Event event) {
        return event.getDate().toString().equals(keywords);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateEqualsPredicate // instanceof handles nulls
                && keywords.equals(((DateEqualsPredicate) other).keywords)); // state check
    }

}
