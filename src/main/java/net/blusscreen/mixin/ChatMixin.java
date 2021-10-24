package net.blusscreen.mixin;

import net.blusscreen.command.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.Arrays;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ChatMixin {
    @Inject(method="sendMessage(Ljava/lang/String;Z)V",at=@At("HEAD"),cancellable = true)
    public void sendMessage(String message, boolean toHud, CallbackInfo ci) {
        if (message.startsWith(".")) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addToMessageHistory(message);
            ci.cancel();
            String messageWithoutPrefix = message.substring(1);
            String[] cmdAndArgs = messageWithoutPrefix.split(" +");
            String command = cmdAndArgs[0].toLowerCase();
            String[] args = Arrays.copyOfRange(cmdAndArgs, 1, cmdAndArgs.length);
            System.out.println(command);
            Command toExecute = CommandRegistry.getInstance().getByAlias(command);
            if (toExecute == null) {
              MinecraftClient.getInstance().player.sendMessage(Text.of("I didnt find any command with that name"), false);
            } else toExecute.execute(args);
            return;
          };
        System.out.println("User sent "+message+" to the server.");
    }
}