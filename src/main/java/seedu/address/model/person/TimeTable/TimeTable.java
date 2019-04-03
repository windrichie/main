package seedu.address.model.person.TimeTable;

/**
 * Represents a Timetable in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class TimeTable {

    private final int NUM_DAYS = 7;
    private final int NUM_HOURS = 24;
    private String[][] timeTable;

    public TimeTable() {
        this.timeTable = new String[NUM_DAYS][NUM_HOURS];
    }

    public String[][] getTimeTable() {
        return this.timeTable;
    }

    public void add(Activity activity, int day, int hour) {
        if (timeTable[day][hour] == null) {
            timeTable[day][hour] = activity.getActivityName();
        }
    }
}
