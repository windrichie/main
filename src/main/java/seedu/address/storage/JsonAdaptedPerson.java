package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.modulelist.Module;
import seedu.address.model.person.modulelist.ModuleList;
import seedu.address.model.person.timetable.TimeTable;
import seedu.address.model.tag.Tag;



/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private String[][] timeTable = new String[TimeTable.NUM_DAYS][TimeTable.NUM_30MINS_BLOCKS];
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();
    private ArrayList<Module> modules = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email, @JsonProperty("address") String address,
                             @JsonProperty("tagged") List<JsonAdaptedTag> tagged,
                             @JsonProperty("timeTable") String[][] timeTable,
                             @JsonProperty("modules") List<String> modules) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
        ArrayList<Module> temp = new ArrayList<>();
        Iterator iterator = modules.iterator();
        while (iterator.hasNext()) {
            temp.add(new Module((String) (iterator.next())));
        }
        this.modules = temp;
        System.arraycopy(timeTable, 0, this.timeTable, 0, timeTable.length);

    }
    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        timeTable = source.getTimeTable().getTimeTableArray();
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        Iterator i = source.getModules().getModuleList().iterator();
        while (i.hasNext()) {
            modules.add((Module) (i.next()));
        }

    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);
        if (modules == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ModuleList.class.getSimpleName()));
        }


        final Set<Tag> modelTags = new HashSet<>(personTags);

        ModuleList tempList = new ModuleList();
        for (Module m:modules
             ) {
            if (!Module.isValidModule(m.getModuleCode())) {
                throw new IllegalValueException(Module.MESSAGE_CONSTRAINTS);
            } else {
                tempList.add(m);
            }
        }
        final ModuleList modelModuleList = tempList;

        TimeTable tempTimeTable = new TimeTable();
        System.arraycopy(timeTable, 0, tempTimeTable.getTimeTableArray(), 0, TimeTable.NUM_DAYS);
        final TimeTable modelTimetable = tempTimeTable;

        return new Person(modelName, modelPhone, modelEmail, modelAddress, modelTags, modelModuleList, modelTimetable);
    }

}
