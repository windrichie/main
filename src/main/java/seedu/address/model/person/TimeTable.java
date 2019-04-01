package seedu.address.model.person;

/**
 * Represents a Timetable in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class TimeTable {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";



    private final int NUM_DAYS = 7;
    private final int NUM_HOURS = 24;
    private Activity[][] timeTable;

    public TimeTable(){
       this.timeTable = new Activity[NUM_DAYS][NUM_HOURS];
    }

    public Activity[][] getTimeTable(){
        return this.timeTable;
    }

    public void add (Activity activity, int day, int hour){
        if(timeTable[day][hour] == null) {
            timeTable[day][hour] = activity;
        }
    }



}
