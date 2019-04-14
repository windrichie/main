package seedu.address.model.person.timetable;

/**
 * Represents a Timetable in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class TimeTable {

    public static final int NUM_DAYS = 7;
    public static final int NUM_30MINS_BLOCKS = 48; //24 hours * 2 30mins block per hour
    private String[][] timeTable;

    public TimeTable() {
        this.timeTable = new String[NUM_DAYS][NUM_30MINS_BLOCKS];
    }

    public TimeTable(String[][] timeTable) {
        this.timeTable = timeTable;
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

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int x = 0; x < NUM_DAYS; x++) {
            for (int y = 0; y < NUM_30MINS_BLOCKS; y++) {
                if (timeTable[x][y] != null) {
                    builder.append("[").append(x).append("]")
                            .append("[").append(y).append("]")
                            .append("=").append(timeTable[x][y]).append(" ");
                }
            }
        }
        return builder.toString();
    }
}
