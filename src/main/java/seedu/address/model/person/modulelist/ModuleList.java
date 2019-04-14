package seedu.address.model.person.modulelist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a list of modules a person is taking.
 */
public class ModuleList {

    private ArrayList<Module> modules;

    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ModuleList(String[] modList) {
        this.modules = new ArrayList<>();
        for (String i:modList
             ) {
            this.modules.add(new Module(i));
        }
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

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        Iterator i = this.modules.iterator();
        while (i.hasNext()) {
            builder.append((i.next()))
                    .append(" ");
        }
        return builder.toString();
    }
}
