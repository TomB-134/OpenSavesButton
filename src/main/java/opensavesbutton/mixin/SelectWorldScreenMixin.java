package opensavesbutton.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.io.File;

@Mixin(SelectWorldScreen.class)
public class SelectWorldScreenMixin extends Screen {
    protected SelectWorldScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "init()V") //Basically hijacking the init method to add our own fun button.
    public void init(CallbackInfo info) {
        this.addButton(new ButtonWidget(this.width / 2 + 160, //Create said fun button.
                this.height - 28, 72, 20,
                new LiteralText("Folder"),
                (button -> openSavesFolder(this.client)))); //On button press call openSavesFolder method.
    }

    private void openSavesFolder(MinecraftClient client) {
        File file = new File(client.runDirectory + "\\saves"); //Create saves file from current running directory.
        Util.getOperatingSystem().open(file); //Amazingly, minecraft already has a method for opening a file.
    }
}
