package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.collections.ObservableList;
import seedu.address.commons.util.InvalidationListenerManager;
import seedu.address.model.event.Event;
import seedu.address.model.event.UniqueEventList;

//@@author windrichie
/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class EventCalendar implements ReadOnlyEventCalendar {

    private final UniqueEventList events;
    private final InvalidationListenerManager invalidationListenerManager = new InvalidationListenerManager();

    /*
     * The 'unusual' code block below is an non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        events = new UniqueEventList();
    }

    public EventCalendar() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public EventCalendar(ReadOnlyEventCalendar toBeCopied) {
        this();
        resetData(toBeCopied);
    }


    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setEvents(List<Event> events) {
        this.events.setEvents(events);
        indicateModified();
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyEventCalendar newData) {
        requireNonNull(newData);

        setEvents(newData.getEventList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasEvent(Event event) {
        requireNonNull(event);
        return events.contains(event);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addEvent(Event e) {
        events.add(e);
        indicateModified();
    }

    /**
     * Replaces the given event {@code target} in the list with {@code editedEvent}.
     * {@code target} must exist in the event calendar.
     * The event identity of {@code editedEvent} must not be the same as another existing event in the event calendar.
     */
    public void setPerson(Event target, Event editedEvent) {
        requireNonNull(editedEvent);

        events.setEvent(target, editedEvent);
        indicateModified();
    }

    /**
     * Removes {@code key} from this {@code EventCalendar}.
     * {@code key} must exist in the event calendar.
     */
    public void removeEvent(Event key) {
        events.remove(key);
        indicateModified();
    }

    @Override
    public void addListener(InvalidationListener listener) {
        invalidationListenerManager.addListener(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        invalidationListenerManager.removeListener(listener);
    }

    /**
     * Notifies listeners that the address book has been modified.
     */
    protected void indicateModified() {
        invalidationListenerManager.callListeners(this);
    }

    //// util methods

    @Override
    public String toString() {
        return events.asUnmodifiableObservableList().size() + " events";
        // TODO: refine later
    }

    @Override
    public ObservableList<Event> getEventList() {
        return events.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EventCalendar // instanceof handles nulls
                && events.equals(((EventCalendar) other).events));
    }

    @Override
    public int hashCode() {
        return events.hashCode();
    }
}
