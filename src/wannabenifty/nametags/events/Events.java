package wannabenifty.nametags.events;

import com.lkeehl.tagapi.TagBuilder;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import wannabenifty.nametags.Main;

public class Events implements Listener {

    @EventHandler
    public static void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.getPlayer().setDisplayName(event.getPlayer().getName());
        String Tag;

        try {
            Main main = JavaPlugin.getPlugin(Main.class);
            FileConfiguration config = main.getConfig();
            String UUID = event.getPlayer().getUniqueId().toString();
            Tag = config.getString(UUID + ".tag");
            System.out.println(event.getPlayer().getUniqueId().toString() + ".tag");
            if (Tag == null || Tag.isEmpty()) {
                Tag = "[Beginner]";
                System.out.println("[NameTags]: No rank found.");
            }
        }
        catch (Exception e) {
            System.out.println("[NameTags]: There was an error while loading the config file.");
            System.out.println("[NameTags]: Error message : " + e.getStackTrace());
            Tag = "";
        }
        final String finalTag = Tag;
        System.out.println("[NameTags]: Adding rank " + finalTag + " to player " + event.getPlayer().getName() + ".");
        event.getPlayer().setDisplayName("");
        event.getPlayer().setDisplayName(ChatColor.YELLOW + finalTag + ChatColor.RESET + event.getPlayer().getName());
        event.getPlayer().setPlayerListName(ChatColor.YELLOW + finalTag + ChatColor.RESET + event.getPlayer().getName());
        TagBuilder builder = TagBuilder.create(event.getPlayer());

        builder.withLine(player -> ChatColor.YELLOW + finalTag + ChatColor.RESET + event.getPlayer().getName());
        builder.build();
        System.out.println("[NameTags]: Successfully added tag to Player " + event.getPlayer().getName() + " with UUID " + event.getPlayer().getUniqueId());
    }
}