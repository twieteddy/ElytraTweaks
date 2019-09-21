package io.github.twieteddy.elytratweaks.utils;

import java.io.File;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
  private YamlConfiguration config = null;

  public Config(JavaPlugin plugin) {
    File configFile = new File(plugin.getDataFolder(), "config.yml");
    if (!configFile.exists()) {
      plugin.saveResource("config.yml", false);
    }
    this.config = YamlConfiguration.loadConfiguration(configFile);
  }

  public String getMessage(String messageNode) {
    ConfigurationSection messageSection = this.config.getConfigurationSection("message");
    String message = messageSection.getString(messageNode, messageNode);
    return ChatColor.translateAlternateColorCodes('&', message);
  }

  public String getInfiniteFireworkPrefix() {
    String identifier = this.config.getString("infinite_firework_prefix", null);
    return ChatColor.translateAlternateColorCodes('&', identifier);
  }
}
