package seedu.address.model.person.modulelist;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Represents a list of modules a person is taking.
 */
public class ModuleList {

    private ArrayList<String> modules;

    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ModuleList(ArrayList<String> modules){
        this.modules = modules;
    }

    public ArrayList<String> getModuleList() {
        return this.modules;
    }

    /**
     * adds a module to the Module list of a person.
     */
    public void add(String module) {
        //Create exception for multiple modules of the same type.
        modules.add(module);
    }
}
