package io.github.twieteddy.elytratweaks.utils;

import java.io.File;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A facade for the config class. Implements the
 * ability to get custom messages the config file.
 */
public class Config {
  private YamlConfiguration config = null;

  /**
   * Create config.yml if it doesn't exist and read it.
   * @param plugin reference to the base plugin
   */
  public Config(JavaPlugin plugin) {
    File configFile = new File(plugin.getDataFolder(), "config.yml");
    if (!configFile.exists()) {
      plugin.saveResource("config.yml", false);
    }
    this.config = YamlConfiguration.loadConfiguration(configFile);
  }

  /**
   * Get a configured message by the name of the node
   * @param messageNode
   * @return the message as a string
   */
  public String getMessage(String messageNode) {
    ConfigurationSection messageSection = this.config.getConfigurationSection("message");
    String message = messageSection.getString(messageNode, messageNode);
    return ChatColor.translateAlternateColorCodes('&', message);
  }

  /**
   * Returns the prefix of the infinitely boosting firework
   * @return the prefix to identify the firework
   */
  public String getInfiniteFireworkPrefix() {
    String identifier = this.config.getString("infinite_firework_prefix", null);
    return ChatColor.translateAlternateColorCodes('&', identifier);
  }
}
