package net.blusscreen;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
// import net.minecraft.text.TranslatableText;
// import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.MinecraftClient;
// import net.blusscreen.ConfigureGUI;

import java.awt.*;
import java.net.URI;

public class TestGUI extends Screen {
    protected Screen parentScreen;
    public TestGUI(Screen parentScreen) {
        super(Text.of("123"));
        this.parentScreen = parentScreen;
        // init();
    }

    // @Override
    // protected void init() {
    //     // new TranslatableText("net.blusutils.btn")
    //     // return;
    // }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // DrawableHelper.fill(matrices,50,50,300,300, Color.DARK_GRAY.getRGB());
        // DrawableHelper.drawTextWithShadow(matrices, textRenderer, new TranslatableText("net.blusutils.testText"), 120, 100, Color.blue.getRGB());
        // DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.of("the"), 145, 100, Color.blue.getRGB());
        // DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.of("gui"), 165, 100, Color.blue.getRGB());
        addButton(new ButtonWidget(10, 10, 70, 35, new TranslatableText("net.blusutils.childGUI.configure.buttonOpen"), b -> {
            // sendMessage("Hello blyat");
            MinecraftClient.getInstance().openScreen(new ConfigureGUI(this));
            // super.openLink(new URI("https://google.com"));
        }));
        
        
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void onClose() {
        MinecraftClient.getInstance().openScreen(parentScreen);
    }

    public TestGUI getInstance () {
        return this;
    }
}

// class Clck extends ButtonWidget {
//     public int x;
//     public int y;
//     public int width;
//     public int height;
//     public Text message;
//     public PressAction onPress;

//     public Clck (int x, int y, int width, int height, Text message) {
//         super(x, y, width, height, message, pa -> {});
//         // super.onPress = this.onPress;
//         this.x=x;
//         this.y=y;
//         this.width = width;
//         this.height = height;
//         this.message = message;
//     }

//     public void onPress (ButtonWidget btn) {

//     }
// }
