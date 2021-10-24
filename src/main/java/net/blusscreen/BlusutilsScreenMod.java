package net.blusscreen;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.blusscreen.command.CommandRegistry;
import net.blusscreen.command.impl.Toggle;
import net.blusscreen.module.ModuleRegistry;
import net.blusscreen.module.impl.OpenGUI;

public class BlusutilsScreenMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("blusscreen");
	private CommandRegistry cmdRegister = new CommandRegistry();
	private ModuleRegistry mdlRegister = new ModuleRegistry();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		cmdRegister.register(new Toggle());
		mdlRegister.register(new OpenGUI());
	}
}
