package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.event.Date;
import seedu.address.model.event.Description;
import seedu.address.model.event.DressCode;
import seedu.address.model.event.Event;
import seedu.address.model.event.TargetAudience;
import seedu.address.model.event.Time;
import seedu.address.model.event.Title;
import seedu.address.model.event.Venue;

//@@author windrichie
/**
 * Jackson-friendly version of {@link Event}.
 */
class JsonAdaptedEvent {

    private static final String MISSING_FIELD_MESSAGE_FORMAT = "Event's %s field is missing!";

    private final String title;
    private final String venue;
    private final String date;
    private final String time;
    private final String desc;
    private final String code;
    private final String audience;

    /**
     * Constructs a {@code JsonAdaptedEvent} with the given event details.
     */
    @JsonCreator
    public JsonAdaptedEvent(@JsonProperty("title") String title, @JsonProperty("venue") String venue,
                            @JsonProperty("date") String date, @JsonProperty("time") String time,
                            @JsonProperty("desc") String desc, @JsonProperty("code") String code,
                            @JsonProperty("audience") String audience) {
        this.title = title;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.code = code;
        this.audience = audience;
    }

    /**
     * Converts a given {@code Event} into this class for Jackson use.
     */
    public JsonAdaptedEvent(Event source) {
        title = source.getTitle().toString();
        venue = source.getVenue().toString();
        date = source.getDate().toString();
        time = source.getTime().startEndTimeToString();
        desc = source.getDesc().toString();
        code = source.getCode().toString();
        audience = source.getAudience().toString();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Event toModelType() throws IllegalValueException {

        if (title == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName()));
        }
        if (!Title.isValidTitle(title)) {
            throw new IllegalValueException(Title.MESSAGE_CONSTRAINTS);
        }
        final Title modelTitle = new Title(title);

        if (venue == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Venue.class.getSimpleName()));
        }
        if (!Venue.isValidVenue(venue)) {
            throw new IllegalValueException(Venue.MESSAGE_CONSTRAINTS);
        }
        final Venue modelVenue = new Venue(venue);

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        if (!Date.isValidDate(date)) {
            throw new IllegalValueException(Date.MESSAGE_CONSTRAINTS);
        }
        final Date modelDate = new Date(date);

        if (time == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Time.class.getSimpleName()));
        }

        String[] times = time.split("-");

        if (times.length != 2) {
            throw new IllegalValueException(Time.MESSAGE_END_TIME_MISSING);
        }
        String startTime = times[0];
        String endTime = times[1];

        if ((!Time.isValidTime(startTime)) || (!Time.isValidTime(endTime))) {
            throw new IllegalValueException(Time.MESSAGE_CONSTRAINTS);
        }
        final Time modelTime = new Time(startTime, endTime);

        if (desc == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Description.class.getSimpleName()));
        }
        if (!Description.isValidDescription(desc)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDesc = new Description(desc);

        if (code == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DressCode.class.getSimpleName()));
        }
        if (!DressCode.isValidDressCode(code)) {
            throw new IllegalValueException(DressCode.MESSAGE_CONSTRAINTS);
        }
        final DressCode modelCode = new DressCode(code);

        if (audience == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TargetAudience.class.getSimpleName()));
        }
        if (!TargetAudience.isValidTargetAudience(audience)) {
            throw new IllegalValueException(TargetAudience.MESSAGE_CONSTRAINTS);
        }
        final TargetAudience modelAudience = new TargetAudience(audience);

        return new Event(modelTitle, modelVenue, modelDate, modelTime, modelDesc, modelCode, modelAudience);
    }

}
