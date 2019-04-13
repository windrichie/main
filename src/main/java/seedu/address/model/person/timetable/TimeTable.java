package seedu.address.model.person.timetable;

import seedu.address.model.event.Time;

/**
 * Represents a Timetable in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class TimeTable {

    private static final int NUM_DAYS = 7;
    private static final int NUM_HOURS = 24;
    private String[][] timeTable;

    public TimeTable() {
        this.timeTable = new String[NUM_DAYS][NUM_HOURS];
    }

    public TimeTable(String[][] timeTable){
        this.timeTable = timeTable;
    }

    public String[][] getTimeTableArray() {
        return this.timeTable;
    }

    /**
     * adds a an activity to a persons timetable.
     */
    public void add(Activity activity, int day, int hour) {
        if (timeTable[day][hour] == null) {
            timeTable[day][hour] = activity.getActivityName();
        }
    }
}
