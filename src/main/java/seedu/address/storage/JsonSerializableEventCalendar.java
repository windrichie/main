package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.EventCalendar;
import seedu.address.model.ReadOnlyEventCalendar;
import seedu.address.model.event.Event;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "eventcalendar")
class JsonSerializableEventCalendar {

    public static final String MESSAGE_DUPLICATE_EVENT = "Events list contains duplicate person(s).";

    private final List<JsonAdaptedEvent> events = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableEventCalendar} with the given persons.
     */
    @JsonCreator
    public JsonSerializableEventCalendar(@JsonProperty("events") List<JsonAdaptedEvent> events) {
        this.events.addAll(events);
    }

    /**
     * Converts a given {@code ReadOnlyEventCalendar} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableEventCalendar}.
     */
    public JsonSerializableEventCalendar(ReadOnlyEventCalendar source) {
        events.addAll(source.getEventList().stream().map(JsonAdaptedEvent::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code EventCalendar} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public EventCalendar toModelType() throws IllegalValueException {
        EventCalendar eventCalendar = new EventCalendar();
        for (JsonAdaptedEvent jsonAdaptedEvent : events) {
            Event event = jsonAdaptedEvent.toModelType();
            if (eventCalendar.hasEvent(event)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_EVENT);
            }
            eventCalendar.addEvent(event);
        }
        return eventCalendar;
    }

}
