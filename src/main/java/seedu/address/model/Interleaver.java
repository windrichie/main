package seedu.address.model;


/**
 * All interleaving is done here
 */
public class Interleaver {

    private static final int FOCUS_PERIOD = 30; //in mins. Default and minimum is 30. Max is 120
    private static final int REST_DURATION = 5; //in mins. Default and minimum is 5. Max is 120
    //Assume each module has 3 hours self study.

    public void extractSelfStudyHours() {
        //remove from guides
    }

    public void split() {
        //split each module into 30 mins blocks.
    }

    public void interleave() {
        //store all blocks in stack??
        //for each block, insert them into free time slots.
    }

    //dont need generate method anymore?

}
