package wannabenifty.nametags;

import com.lkeehl.tagapi.TagAPI;
import org.bukkit.Tag;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import wannabenifty.nametags.events.Events;

public class Main extends JavaPlugin {
    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        TagAPI.onEnable(this);
        System.out.println("[NameTags]: Plugin has successfully started!");
        getServer().getPluginManager().registerEvents(new Events() , this);
        this.getConfig();
        saveConfig();
    }

    @Override
    public void onDisable() {
        TagAPI.onDisable();
        saveConfig();
        System.out.println("[NameTags]: Plugin was successfully disabled!");
    }
}