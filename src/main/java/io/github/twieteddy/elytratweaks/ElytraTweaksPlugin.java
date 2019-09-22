package io.github.twieteddy.elytratweaks;

import io.github.twieteddy.elytratweaks.events.EntityToggleGlideEventListener;
import io.github.twieteddy.elytratweaks.events.PlayerElytraBoostEventListener;
import io.github.twieteddy.elytratweaks.utils.Config;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraTweaksPlugin extends JavaPlugin {
  private Config config;
  private PluginManager pluginManager;

  /**
   * Called to initialize the plugin
   */
  @Override
  public void onEnable() {
    this.config = new Config(this);
    this.pluginManager = this.getServer().getPluginManager();

    pluginManager.registerEvents(new PlayerElytraBoostEventListener(this), this);
    pluginManager.registerEvents(new EntityToggleGlideEventListener(this), this);
  }

  /**
   * Called while disabling the plugin
   */
  @Override
  public void onDisable() {}

  /**
   * Returns the custom config
   * @return the custom config
   */
  public Config getCfg() {
    return this.config;
  }

}
