package io.github.twieteddy.elytratweaks.listener;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import io.github.twieteddy.elytratweaks.ElytraTweaksPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;


public class SpecialRocketListener implements Listener {
  private final String specialRocketPrefix;

  public SpecialRocketListener (ElytraTweaksPlugin plugin) {
    specialRocketPrefix = (String) plugin.getOption("special_rocket_prefix");
  }

  @SuppressWarnings("unused")
  @EventHandler
  public void onPlayerElytraBoostEvent(PlayerElytraBoostEvent e) {
    if (e.getPlayer().hasPermission("elytratweaks.specialrocket")) {
      FireworkMeta meta = e.getFirework().getFireworkMeta();
      if (meta.hasDisplayName() && meta.getDisplayName().startsWith(specialRocketPrefix))
        e.setShouldConsume(false);
    }
  }
}
