package wannabenifty.nametags;

import com.lkeehl.tagapi.TagAPI;
import org.bukkit.plugin.java.JavaPlugin;
import wannabenifty.nametags.events.ServerEventHandler;

public final class NameTags extends JavaPlugin {

    @Override
    public void onEnable() {
        TagAPI.onEnable(this);
        getServer().getPluginManager().registerEvents(new ServerEventHandler(), this);
    }

    @Override
    public void onDisable() {
        TagAPI.onDisable();
    }
}
