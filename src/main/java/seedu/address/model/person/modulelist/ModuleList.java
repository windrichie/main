package seedu.address.model.person.modulelist;

import java.util.ArrayList;

/**
 * Represents a list of modules a person is taking.
 */
public class ModuleList {

    private ArrayList<Module> modules;

    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ArrayList<Module> getModuleList() {
        return this.modules;
    }

    /**
     * adds a module to the Module list of a person.
     */
    public void add(Module mod) {
        //Create exception for multiple modules of the same type.
        modules.add(mod);
    }
}
