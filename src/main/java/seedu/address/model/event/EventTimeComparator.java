package seedu.address.model.event;

import java.util.Comparator;

/**
 * Compares starting time of 2 events used to sort in ascending order.
 */
public class EventTimeComparator implements Comparator<Event> {
    public int compare(Event event, Event event1) {
        String[] starttime = event.getTime().startTimeToString().split(":");
        String[] starttime1 = event1.getTime().startTimeToString().split(":");

        if (!starttime[0].equals(starttime1[0])) {
            return Integer.valueOf(starttime[0]) - Integer.valueOf(starttime1[0]);
        } else {
            return Integer.valueOf(starttime[1]) - Integer.valueOf(starttime1[1]);
        }
    }
}
