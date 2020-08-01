package opensavesbutton;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenSavesButton implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_NAME = "OpenSavesButton";
    public static final String MOD_VERSION = "v0.0.0";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing " + MOD_NAME + " " + MOD_VERSION);
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}