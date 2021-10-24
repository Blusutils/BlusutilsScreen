package net.blusscreen.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {
    private static ModuleRegistry INSTANCE = null;
    public List<Module> MODULES = new ArrayList<>();
    public ModuleRegistry() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Module registry already exists!");
        }
        INSTANCE = this;
        registerModules();
    }

    public void register(Module module) {
        MODULES.add(module);
    }

    void registerModules() {
        
    }

    public Module getByName(String name) {
        for (Module module : MODULES) {
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public static ModuleRegistry getInstance() {
        if (INSTANCE == null) new ModuleRegistry();
        return INSTANCE;
    }
    
    public List<Module> getAll() {
        return MODULES; 
    }
}