package io.github.twieteddy.elytratweaks;

import io.github.twieteddy.elytratweaks.listener.ElytraGlideDisabler;
import io.github.twieteddy.elytratweaks.listener.ElytraBoostDisabler;
import io.github.twieteddy.elytratweaks.listener.SpecialRocketListener;
import java.io.File;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class ElytraTweaksPlugin extends JavaPlugin {
  private final HashMap<String, Object> options = new HashMap<>();
  private final HashMap<String, String> messages = new HashMap<>();

  @Override
  public void onEnable() {
    loadConfig();
    registerEvents();
  }

  @Override
  public void onDisable() {}

  private void loadConfig() {
    File configFile = new File(getDataFolder(), "config.yml");
    if (!configFile.exists())
      saveResource("config.yml", false);

    YamlConfiguration configYml = YamlConfiguration.loadConfiguration(configFile);
    for (String key : configYml.getKeys(false)) {
      String option = (String) configYml.get(key);
      options.put(key, translateColor(option));
    }

    File messagesFile = new File(getDataFolder(), "messages.yml");
    if (!messagesFile.exists())
      saveResource("messages.yml", false);

    YamlConfiguration messagesYml = YamlConfiguration.loadConfiguration(messagesFile);
    for (String key : messagesYml.getKeys(false)) {
      String message = messagesYml.getString(key);
      messages.put(key, translateColor(message));
    }
  }

  private void registerEvents() {
    PluginManager pluginManager = getServer().getPluginManager();
    pluginManager.registerEvents(new ElytraGlideDisabler(this), this);
    pluginManager.registerEvents(new ElytraBoostDisabler(this), this);
    pluginManager.registerEvents(new SpecialRocketListener(this), this);
  }

  private String translateColor(String text) {
    return ChatColor.translateAlternateColorCodes('&', text);
  }

  public Object getOption(String key) {
    return options.getOrDefault(key, null);
  }

  public String getMessage(String messageName) {
    return messages.getOrDefault(messageName, messageName);
  }
}
