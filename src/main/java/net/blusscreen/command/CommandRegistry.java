package net.blusscreen.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRegistry {
    private static CommandRegistry INSTANCE = null;
    List<Command> COMMANDS = new ArrayList<>();
    public CommandRegistry() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Command registry already exists!");
        }
        INSTANCE = this;
        registerCommands();
    }

    public void register(Command command) {
        COMMANDS.add(command);
    }

    void registerCommands() {

    }

    public Command getByName(String name) {
        for (Command command : COMMANDS) {
            if (command.getName().equalsIgnoreCase(name)) return command;
        }
        return null;
    }

    public Command getByAlias(String search) {
        for (Command command : COMMANDS) {
            if (Arrays.stream(command.aliases).anyMatch(s -> s.equalsIgnoreCase(search))) return command;
        }
        return null;
    }

    public static CommandRegistry getInstance() {
        if (INSTANCE == null) new CommandRegistry();
        return INSTANCE;
    }
}