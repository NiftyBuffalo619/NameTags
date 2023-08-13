package wannabenifty.nametags.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;
import wannabenifty.nametags.NameTags;

public class ServerEventHandler implements Listener {
    @EventHandler
    public static void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String tag = ChatColor.YELLOW + "[RANK]" + ChatColor.RESET + player.getName();
        setPlayerNameTagTab(player , tag);
        createFloatingNameTag(player);
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        // Remove the armor stand when the player quits
        removeFloatingNameTag(player);
    }

    private static void setPlayerNameTagTab(Player player , String tag) {
        Team team = player.getScoreboard().getPlayerTeam(player);
        if (team == null) {
            team = player.getScoreboard().registerNewTeam(player.getName());
        }
        team.setPrefix(tag);
        team.addEntry(player.getName());
    }

    private static void createFloatingNameTag(Player player) {
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        armorStand.setCustomName(ChatColor.YELLOW + "[RANK]" + ChatColor.RESET + player.getName());
        armorStand.setCustomNameVisible(true);
        armorStand.setInvisible(true);
        armorStand.setMarker(true);

        // Update the armor stand's location periodically to follow the player
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline() || player.isDead()) {
                    armorStand.remove();
                    cancel();
                    return;
                }
                armorStand.teleport(player.getLocation().add(0, 2.2, 0));
            }
        }.runTaskTimer(new NameTags(), 0, 10);
    }

    private void removeFloatingNameTag(Player player) {
        // Find and remove the armor stand associated with the player
        player.getWorld().getEntitiesByClass(ArmorStand.class).forEach(armorStand -> {
            if (armorStand.getCustomName() != null && armorStand.getCustomName().contains(player.getName())) {
                armorStand.remove();
            }
        });
    }
}