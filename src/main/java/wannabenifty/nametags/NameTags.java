package wannabenifty.nametags;

import org.bukkit.plugin.java.JavaPlugin;
import wannabenifty.nametags.events.ServerEventHandler;

public final class NameTags extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ServerEventHandler(), this);
    }

    @Override
    public void onDisable() {
    }
}