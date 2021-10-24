package net.blusscreen.command.impl;

import net.blusscreen.command.Command;
import net.blusscreen.module.Module;
import net.blusscreen.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Toggle extends Command {
    public Toggle() {
        super("Toggle","toggles modules","toggle","t","enable","disable");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("I need a module name dude"),false);
            return;
        }
        Module toToggle = ModuleRegistry.getInstance().getByName(String.join(" ",args));
        if (toToggle == null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Didn't find that module"),false);
            System.out.println(ModuleRegistry.getInstance().MODULES.size());
            return;
        }
        toToggle.setEnabled(!toToggle.isEnabled());
        System.out.println(toToggle.getName()+":enabled  "+!toToggle.isEnabled()+" ->  "+toToggle.isEnabled());
    }
}