package seedu.address.model.person.timetable;

/**
 * Represents a Timetable in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class TimeTable {

    public static final int NUM_DAYS = 7;
    public static final int NUM_30MINS_BLOCKS = 24 * 2;
    private String[][] timeTable;

    public TimeTable() {
        this.timeTable = new String[NUM_DAYS][NUM_30MINS_BLOCKS];
    }

    public String[][] getTimeTableArray() {
        return this.timeTable;
    }
    /**
     * adds a an activity to a persons timetable.
     */
    public void add(Activity activity, int day, int hour) { //change to 30 mins blocks
        //todo argument validation
        if (timeTable[day][hour] == null) {
            timeTable[day][hour] = activity.getActivityName();
        }
    }
}
