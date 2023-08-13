package wannabenifty.nametags.events;

import com.lkeehl.tagapi.TagAPI;
import com.lkeehl.tagapi.TagBuilder;
import com.lkeehl.tagapi.api.Tag;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;

public class ServerEventHandler implements Listener {
    @EventHandler
    public static void onPlayerJoinEvent(PlayerJoinEvent event) {
        SetupPlayerTag(event.getPlayer());
    }


    private static void SetupPlayerTag(Player player) {
        TagBuilder builder = TagBuilder.create(player);
        builder.withLine(player1 -> ChatColor.YELLOW + "[RANK]" + ChatColor.RESET + player.getName());
        builder.build();
        System.out.println("[NameTags]: Successfully added Rank to player " + player.getName() + ".");
    }
}