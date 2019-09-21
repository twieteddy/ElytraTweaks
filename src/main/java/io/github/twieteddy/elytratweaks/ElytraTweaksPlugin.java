package io.github.twieteddy.elytratweaks;

import io.github.twieteddy.elytratweaks.events.EntityToggleGlideEventListener;
import io.github.twieteddy.elytratweaks.events.PlayerElytraBoostEventListener;
import io.github.twieteddy.elytratweaks.utils.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraTweaksPlugin extends JavaPlugin {
  private Config config;

  @Override
  public void onEnable() {
    this.config = new Config(this);

    this.getServer().getPluginManager()
        .registerEvents(new PlayerElytraBoostEventListener(this), this);
    this.getServer().getPluginManager()
        .registerEvents(new EntityToggleGlideEventListener(this), this);
  }

  @Override
  public void onDisable() {}

  public Config getCfg() {
    return this.config;
  }

}
