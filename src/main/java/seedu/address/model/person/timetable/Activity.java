package seedu.address.model.person.timetable;

import seedu.address.model.event.Event;
import seedu.address.model.person.modulelist.Module;

/**
 * Represents an activity in the Learning Scheduler.
 */
public class Activity {

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    public static final String[] DAY_MAPPING = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
        "Saturday", "Sunday"};

    private final Module module;
    private final Event event;
    private final String activity;
    private final String day;
    private final String time;
    //private final StudyTime study;

    public Activity(String activity) {
        this.activity = activity;
        this.module = null;
        this.event = null;
        this.day = null;
        this.time = null;
    }

    public Activity(Event event) {
        this.event = event;
        this.activity = null;
        this.module = null;
        this.day = null;
        this.time = null;
    }

    public Activity(String activity, int day, int time) {
        this.activity = activity;
        this.module = null;
        this.event = null;
        this.day = DAY_MAPPING[day];
        this.time = Integer.toString(time) + ":00 - " + Integer.toString(time + 1) + ":00";
    }


    public Module getModule() {
        return module;
    }

    public Event getEvent() {
        return event;
    }

    public static boolean isValidActivity(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getActivityName() {
        return activity;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    /*@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && moduleCode.equals(((Phone) other).moduleCode)); // state check
    }

    @Override
    public int hashCode() {
        return moduleCode.hashCode();
    }*/
}
