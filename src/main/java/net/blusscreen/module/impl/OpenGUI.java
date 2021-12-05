package net.blusscreen.module.impl;

import net.blusscreen.TestGUI;
import net.blusscreen.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class OpenGUI extends Module {
    public OpenGUI() {
        super("OpenGUI","Opens the gui");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        MinecraftClient instance = MinecraftClient.getInstance();
        setEnabled(false);
        instance.openScreen(new TestGUI(instance.currentScreen));
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}