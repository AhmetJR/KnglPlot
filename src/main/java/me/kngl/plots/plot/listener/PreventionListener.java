package me.kngl.plots.plot.listener;

import me.kngl.plots.KnglPlotsPlugin;
import me.kngl.plots.PlotsAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.projectiles.ProjectileSource;
import org.jetbrains.annotations.NotNull;

public class PreventionListener implements Listener {

    private final @NotNull KnglPlotsPlugin plugin;

    public PreventionListener(@NotNull KnglPlotsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!PlotsAPI.checkPlayerCan(player, event.getBlockPlaced().getLocation(), true)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        int blockY = event.getBlock().getY();
        if (!PlotsAPI.checkPlayerCan(player, event.getBlock().getLocation(), true)) {
            if (event.getBlock().getLocation().getY() == 25) {
                event.setCancelled(true);
                player.sendMessage("§cBu yükseklikte blok kıramazsınız.");
                return;
            }
        }


        if (!PlotsAPI.checkPlayerCan(player, event.getBlock().getLocation(), true)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!PlotsAPI.checkPlayerCan(player, player.getLocation(), true)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void OnMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!PlotsAPI.checkPlayerCan(player, event.getTo(), true)) {
            player.chat("/arsa git");
            event.setCancelled(true);

        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        ProjectileSource shooter = event.getEntity().getShooter();
        if (shooter == null || !(shooter instanceof Player)) return;
        Player player = (Player) shooter;

        if (!PlotsAPI.checkPlayerCan(player, player.getLocation(), true)) {
            event.setCancelled(true);
        }
    }

}