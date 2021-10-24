package net.blusscreen;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.awt.*;

public class TestGUI extends Screen {
    public TestGUI() {
        super(Text.of("123"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices,5,5,100,100, Color.decode("123").getRGB());
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.of(""), 500, 500, Color.getHSBColor(5, 3, 100).getRGB());
        // super.addButton(new T());
        super.render(matrices, mouseX, mouseY, delta);
    }
}