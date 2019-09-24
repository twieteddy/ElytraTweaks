package io.github.twieteddy.elytratweaks.listener;

import io.github.twieteddy.elytratweaks.ElytraTweaksPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;


public class ElytraGlideDisabler implements Listener {
  private final String elytraGlideDisabledMessage;

  public ElytraGlideDisabler(ElytraTweaksPlugin plugin) {
    elytraGlideDisabledMessage = plugin.getMessage("elytraglide_disabled");
  }

  @SuppressWarnings("unused")
  @EventHandler
  public void onEntityToggleGlideEvent(EntityToggleGlideEvent e) {
    if (e.getEntity() instanceof Player) {
      Player player = (Player) e.getEntity();
      if (!player.hasPermission("elytratweaks.glide")) {
        e.setCancelled(true);
        player.spigot().sendMessage(
            ChatMessageType.ACTION_BAR,
            new ComponentBuilder(elytraGlideDisabledMessage)
                .color(ChatColor.RED)
                .create());
      }
    }
  }
}
