package seedu.address.model.person;

/**
 * Represents a Module in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class Module {
    private TimeSlot timeslot;


    public TimeSlot getTimeslot(){
        return this.timeslot;
    }

    public void setTimeSlot(TimeSlot timeslot){
        this.timeslot = timeslot;
    }



}
