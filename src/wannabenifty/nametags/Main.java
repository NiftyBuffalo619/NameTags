package wannabenifty.nametags;

import com.lkeehl.tagapi.TagAPI;
import org.bukkit.Tag;
import org.bukkit.plugin.java.JavaPlugin;
import wannabenifty.nametags.events.Events;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        TagAPI.onEnable(this);
        System.out.println("[NameTags]: Plugin has successfully started!");
        getServer().getPluginManager().registerEvents(new Events() , this);
    }

    @Override
    public void onDisable() {
        TagAPI.onDisable();
        System.out.println("[NameTags]: Plugin was successfully disabled!");
    }
}