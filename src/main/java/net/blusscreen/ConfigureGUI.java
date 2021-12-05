package net.blusscreen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ConfigureGUI extends Screen {
    protected Screen parentScreen;
    public ConfigureGUI (Screen parentScreen) {
        super(Text.of("configure"));
        this.parentScreen = parentScreen;
    }
    @Override
    public void render (MatrixStack matrices, int mouseX, int mouseY, float delta) {
        addButton(new ButtonWidget(width-65, 10, 20, 20, Text.of("+"), b -> {
            
        }));
        addButton(new ButtonWidget(width-40, 10, 20, 20, Text.of("-"), b -> {
          
        }));
        addButton(new ButtonWidget(width-65, 35, 45, 20, new TranslatableText("net.blusutils.childGUI.configure.buttonConfirm"), b -> {
          
        }));
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void onClose() {
        MinecraftClient.getInstance().openScreen(parentScreen);
    }

    public ConfigureGUI getInstance () {
        return this;
    }
}
