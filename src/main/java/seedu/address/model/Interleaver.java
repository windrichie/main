package seedu.address.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import seedu.address.model.person.Person;
import seedu.address.model.person.modulelist.Module;
import seedu.address.model.person.timetable.TimeTable;

/**
 * All interleaving is done here
 */
public class Interleaver {

    private static final double FOCUS_PERIOD = 0.5; //in hours for now
    //private static final int FOCUS_PERIOD = 30; //in mins. Default and minimum is 30. Max is 120.

    /**
     * Controls this class methods
     */
    public static TimeTable interleave(Person person) {
        ArrayList<Module> modules = person.getModules().getModuleList();
        ArrayList<Stack> blocksOfModules = new ArrayList<>();
        int totalStudyHoursPerWeek = 0;
        Iterator i = modules.iterator();
        while (i.hasNext()) {
            Module currentMod = (Module) (i.next());
            Stack<String> moduleBlocks = new Stack<>();
            for (int k = 0; k < (currentMod.getSelfStudyHours() / FOCUS_PERIOD); k++) {
                moduleBlocks.push(currentMod.getActivityName());
                totalStudyHoursPerWeek++;
            }
            blocksOfModules.add(moduleBlocks);
        }
        i = blocksOfModules.iterator();
        while (!blocksOfModules.isEmpty()) {
            for (int a = 0; a < TimeTable.NUM_DAYS; a++) { // iterate timetable for free slots
                for (int b = 0; b < TimeTable.NUM_30MINS_BLOCKS; b++) { // starting from 0800
                    String timeSlot = person.getTimeTable().getTimeTableArray()[a][b];
                    if ( timeSlot == null) {
                        timeSlot = (String) (((Stack) (i.next())).pop());
                    }


                }
            }
            //access a stack
        }

        //for each block, insert them into free time slots.
        return null;
    }

    //dont need generate method anymore?

}
