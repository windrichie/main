package seedu.address.model.person;

/**
 * Represents a TimeSlot in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */

public class TimeSlot {

    public static final int TIMES = 24;
    public static final int DAYS = 7;
    private Module module;
    private Slot slot;
    private int[][] TimeBusy =  new int[DAYS][TIMES];
}
