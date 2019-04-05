package seedu.address.model.person.TimeTable;

import seedu.address.model.event.Event;
import seedu.address.model.person.Modules.Module;

public class Activity {

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    private final Module module;
    private final Event event;
    private final String activity;
    //private final StudyTime study;

    public Activity(String activity){
        this.activity = activity;
        this.module = null;
        this.event = null;
    }

   /* public Activity(Module module){
        this.module = module;
        this.activity = null;
        this.event = null;
    }*/

    public Activity(Event event){
        this.event = event;
        this.activity = null;
        this.module = null;
    }


    public Module getModule(){ return module; }

    public Event getEvent(){ return event; }

    public static boolean isValidActivity(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getActivityName(){
        return activity;
    }


    /*@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }*/
}
