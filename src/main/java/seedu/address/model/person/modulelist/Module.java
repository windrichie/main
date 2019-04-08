package seedu.address.model.person.modulelist;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.person.timetable.Activity;

/**
 * New Module class
 */


public class Module extends Activity {

    private static final String MESSAGE_CONSTRAINTS =
            "Module should contain a 2-4 letter department code followed by a four digit course code";
    private static final String VALIDATION_REGEX = "\\w{2,4}\\d{4}";
    private final String moduleCode;
    private int selfStudyHours;

    /**
     * Constructs a {@code Module}.
     *
     * @param module A valid phone number.
     */
    public Module(String module) {
        super(module);
        requireNonNull(module);
        checkArgument(isValidModule(module), MESSAGE_CONSTRAINTS);
        this.moduleCode = module;
        this.selfStudyHours = 3;
    }

    public int getSelfStudyHours() {
        return selfStudyHours;
    }

    public void setSelfStudyHours(int selfStudyHours) {
        this.selfStudyHours = selfStudyHours;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidModule(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return moduleCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Module // instanceof handles nulls
                && moduleCode.equals(((Module) other).moduleCode)); // state check
    }

    @Override
    public int hashCode() {
        return moduleCode.hashCode();
    }

}
