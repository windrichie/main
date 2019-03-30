package seedu.address.model.event;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents an Event in the event calendar.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Event {

    private final Title title;
    private final Venue venue;
    private final Date date;
    private final Time time;
    private final Description desc;
    private final DressCode code;
    private final TargetAudience audience;

    /**
     * Every field must be present and not null.
     */
    public Event(Title title, Venue venue, Date date, Time time, Description desc, DressCode code,
                 TargetAudience audience) {
        requireAllNonNull(title, venue, date, time, desc, code, audience);
        this.title = title;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.code = code;
        this.audience = audience;
    }

    public Title getTitle() {
        return title;
    }

    public Venue getVenue() {
        return venue;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public Description getDesc() {
        return desc;
    }

    public DressCode getCode() {
        return code;
    }

    public TargetAudience getAudience() {
        return audience;
    }

    /**
     * Returns true if both events have the same name, time and venue.
     * This defines a weaker notion of equality between two events.
     */
    public boolean isSameEvent(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getTitle().equals(getTitle())
                && otherEvent.getTime().equals(getTime())
                && otherEvent.getDate().equals(getDate());
    }

    /**
     * Returns true if both events have all the same fields.
     * This defines a stronger notion of equality between two events.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return otherEvent.getTitle().equals(getTitle())
                && otherEvent.getVenue().equals(getVenue())
                && otherEvent.getDate().equals(getDate())
                && otherEvent.getTime().equals(getTime())
                && otherEvent.getDesc().equals(getDesc())
                && otherEvent.getCode().equals(getCode())
                && otherEvent.getAudience().equals(getAudience());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, venue, date, time, desc, code, audience);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Venue: ")
                .append(getVenue())
                .append(" Date: ")
                .append(getDate())
                .append(" Start Time: ")
                .append(getTime().startTimeToString())
                .append(" End Time: ")
                .append(getTime().endTimeToString())
                .append(" Description: ")
                .append(getDesc())
                .append(" Dress Code: ")
                .append(getCode())
                .append(" Target Audience: ")
                .append(getAudience());
        return builder.toString();
    }

}
