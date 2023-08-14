package wannabenifty.nametags.events;

import com.lkeehl.tagapi.TagBuilder;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    @EventHandler
    public static void onPlayerJoinEvent(PlayerJoinEvent event) {
        TagBuilder builder = TagBuilder.create(event.getPlayer());

        event.getPlayer().setPlayerListName(ChatColor.YELLOW + "[RANK] " + ChatColor.RESET + event.getPlayer().getName());
        builder.withLine(player -> ChatColor.YELLOW + "[RANK] " + ChatColor.RESET + event.getPlayer().getName());
        builder.build();
        System.out.println("[NameTags]: Successfully added tag to Player " + event.getPlayer().getName() + "with UUID " + event.getPlayer().getUniqueId());
    }
}
