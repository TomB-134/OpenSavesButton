package opensavesbutton;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenSavesButton implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    //Mod details
    public static final String MOD_NAME = "OpenSavesButton";
    public static final String MOD_VERSION = "v0.0.2";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing " + MOD_NAME + " " + MOD_VERSION); //Let the console know mod initialisation was successful.
    }

    public static void log(Level level, String message){ //Logger method generator by fabric mod generator.
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}