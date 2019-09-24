package io.github.twieteddy.elytratweaks.listener;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import io.github.twieteddy.elytratweaks.ElytraTweaksPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class ElytraBoostDisabler implements Listener {
  private final String elytraBoostDisabledMessage;

  public ElytraBoostDisabler(ElytraTweaksPlugin plugin) {
    elytraBoostDisabledMessage = (String) plugin.getMessage("elytraboost_disabled");
  }

  @SuppressWarnings("unused")
  @EventHandler
  public void onPlayerElytraBoostEvent(PlayerElytraBoostEvent e) {
    if (!e.getPlayer().hasPermission("elytratweaks.boost")) {
      e.setCancelled(true);
      e.getPlayer().spigot().sendMessage(
          ChatMessageType.ACTION_BAR, new ComponentBuilder(elytraBoostDisabledMessage)
              .color(ChatColor.RED)
              .create());
    }
  }
}
