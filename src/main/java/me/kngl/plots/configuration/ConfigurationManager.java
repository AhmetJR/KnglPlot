package me.kngl.plots.configuration;

import me.alpho320.fabulous.core.bukkit.BukkitCore;
import me.alpho320.fabulous.core.bukkit.util.BukkitConfiguration;
import me.alpho320.fabulous.core.bukkit.util.debugger.Debug;
import me.kngl.plots.KnglPlotsPlugin;
import org.bukkit.ChatColor;

public class ConfigurationManager {

    private final KnglPlotsPlugin plugin;
    private BukkitCore core;

    private BukkitConfiguration config;
    private BukkitConfiguration messages;

    public ConfigurationManager(KnglPlotsPlugin plugin) {
        this.plugin = plugin;
    }

    public void reload(boolean loadGuis) {
        setConfig(new BukkitConfiguration("config", plugin));
        setMessages(new BukkitConfiguration("messages", plugin));

        this.core = new BukkitCore(plugin);
        this.core.init(plugin, ChatColor.translateAlternateColorCodes('&', getConfig().getString("Main.prefix", "ServerName")), getMessages());

        Debug.setDebug(getConfig().getBoolean("Main.debug", false));
    }


    public BukkitConfiguration getConfig() {
        return config;
    }

    public void setConfig(BukkitConfiguration config) {
        this.config = config;
    }

    public BukkitConfiguration getMessages() {
        return messages;
    }

    public void setMessages(BukkitConfiguration messages) {
        this.messages = messages;
    }

}