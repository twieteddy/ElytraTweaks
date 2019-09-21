package io.github.twieteddy.elytratweaks.events;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import io.github.twieteddy.elytratweaks.ElytraTweaksPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerElytraBoostEventListener implements Listener {
  private ElytraTweaksPlugin plugin;

  public PlayerElytraBoostEventListener(ElytraTweaksPlugin plugin) { this.plugin = plugin; }

  @EventHandler
  public void disableElytraBoost(PlayerElytraBoostEvent e) {
    if (!e.getPlayer().hasPermission("elytratweaks.boost")) {
      e.setCancelled(true);
      e.getPlayer().spigot().sendMessage(
          ChatMessageType.ACTION_BAR,
          new ComponentBuilder(this.plugin.getCfg().getMessage("elytraboost_disabled"))
              .color(ChatColor.RED)
              .create());
    }
  }

  @EventHandler
  public void infiniteFirework(PlayerElytraBoostEvent e) {
    if (!e.getPlayer().hasPermission("elytratweaks.infinitefirework")) return;

    String displayName = e.getFirework().getFireworkMeta().getDisplayName();

    if (displayName == null) return;

    String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getCfg().getInfiniteFireworkPrefix());

    if (displayName.startsWith(prefix))
      e.setShouldConsume(false);
  }
}
