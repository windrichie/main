package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_MODULE = new Prefix("m/");
    public static final Prefix PREFIX_ACTIVITY = new Prefix("act/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_ACTIVITY_DAY = new Prefix("day/");
    public static final Prefix PREFIX_ACTIVITY_TIME = new Prefix("time/");

    public static final Prefix PREFIX_DATE = new Prefix("ed/");
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("eds/");
    public static final Prefix PREFIX_DRESSCODE = new Prefix("edc/");
    public static final Prefix PREFIX_TARGETAUDIENCE = new Prefix("eta/");
    public static final Prefix PREFIX_TIME = new Prefix("etm/");
    public static final Prefix PREFIX_TITLE = new Prefix("ett/");
    public static final Prefix PREFIX_VENUE = new Prefix("ev/");

    public static final Prefix PREFIX_PERSON = new Prefix("person/");
    public static final Prefix PREFIX_EVENT = new Prefix("event/");

}
