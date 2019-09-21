package io.github.twieteddy.elytratweaks.events;

import io.github.twieteddy.elytratweaks.ElytraTweaksPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class EntityToggleGlideEventListener implements Listener {
  ElytraTweaksPlugin plugin;

  public EntityToggleGlideEventListener(ElytraTweaksPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onEntityToggleGlideEvent(EntityToggleGlideEvent e) {
    if (!(e.getEntity() instanceof Player)) return;
    if (e.getEntity().hasPermission("elytratweaks.glide")) return;

    Player p = (Player) e.getEntity();
    e.setCancelled(true);
    p.spigot()
        .sendMessage(
            ChatMessageType.ACTION_BAR,
            new ComponentBuilder(this.plugin.getCfg().getMessage("elytraglide_disabled"))
                .color(ChatColor.RED)
                .create());
  }
}
