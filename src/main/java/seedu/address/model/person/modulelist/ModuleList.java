package seedu.address.model.person.modulelist;

import java.util.ArrayList;

public class ModuleList {

    private ArrayList<String> modules;

    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ArrayList<String> getModuleList() {
        return this.modules;
    }

    public void add(String module)
    {//Create exception for multiple modules of the same type.
        modules.add(module);
    }
}
