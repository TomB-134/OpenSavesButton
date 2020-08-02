package opensavesbutton.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.io.File;

@Mixin(SelectWorldScreen.class)
public class SelectWorldScreenMixin extends Screen {
    @Shadow protected final Screen parent;
    protected SelectWorldScreenMixin(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Inject(at = @At("HEAD"), method = "init()V") //Inject at UI creation.
    public void init(CallbackInfo info) {
        this.addButton(new ButtonWidget(this.width / 2 + 160, //Create open saves folder button.
                this.height - 28, 72, 20,
                new LiteralText("Folder"),
                (button -> openSavesFolder(this.client)))); //On button press call openSavesFolder method.
        this.addButton(new ButtonWidget(this.width / 2 + 160, //Create reload button
                this.height - 52, 72, 20, new LiteralText("Reload"),
                button -> reload(this.client))); //On button press call reload method
    }

    private void openSavesFolder(MinecraftClient client) {
        File file = new File(client.runDirectory + "\\saves"); //Create saves file from current running directory.
        Util.getOperatingSystem().open(file); //Amazingly, minecraft already has a method for opening a file.
    }

    private void reload(MinecraftClient client) {
        client.openScreen(new SelectWorldScreen(parent)); //Create a new instance of the select world screen and make the client open it.
    }
}
