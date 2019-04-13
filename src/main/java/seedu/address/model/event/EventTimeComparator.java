package seedu.address.model.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Compares starting time of 2 events used to sort in ascending order.
 */
public class EventTimeComparator implements Comparator<Event> {
    public int compare(Event event, Event event1) {
        String[] starttime = event.getTime().startTimeToString().split(":");
        String[] starttime1 = event1.getTime().startTimeToString().split(":");

        String sDate = event.getDate().toString();
        String sDate1 = event1.getDate().toString();

        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        Date date, date1;

        try {
            date = dateParser.parse(sDate);
            date1 = dateParser.parse(sDate1);
        } catch (ParseException e) {
            return -1;
        }

        if (date.equals(date1)) {
            if (!starttime[0].equals(starttime1[0])) {
                return Integer.valueOf(starttime[0]) - Integer.valueOf(starttime1[0]);
            } else {
                return Integer.valueOf(starttime[1]) - Integer.valueOf(starttime1[1]);
            }
        } else {
            if (date.before(date1)) return -1;
            else return 1;
        }


    }
}
