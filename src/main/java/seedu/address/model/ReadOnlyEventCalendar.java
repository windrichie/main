package seedu.address.model;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import seedu.address.model.event.Event;

/**
 * Unmodifiable view of an event calendar
 */
public interface ReadOnlyEventCalendar extends Observable {

    /**
     * Returns an unmodifiable view of the events list.
     * This list will not contain any duplicate events.
     */
    ObservableList<Event> getEventList();

}
