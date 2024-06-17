package net.bluismine.bcash;

import net.bluismine.bcash.commands.Cash;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BCash extends JavaPlugin {

    public static File folder;
    private static BCash instance;
    public static String bukkitVersion;

    @Override
    public void onEnable() {

        final long cur = System.currentTimeMillis();
        instance = this;
        bukkitVersion = Bukkit.getVersion();
        if (bukkitVersion.contains("1.8") &&
                bukkitVersion.contains("1.9") &&
                bukkitVersion.contains("1.10") &&
                bukkitVersion.contains("1.11") &&
                bukkitVersion.contains("1.12") &&
                bukkitVersion.contains("1.13") &&
                bukkitVersion.contains("1.14") &&
                bukkitVersion.contains("1.15") &&
                bukkitVersion.contains("1.16") &&
                bukkitVersion.contains("1.17") &&
                bukkitVersion.contains("1.18") &&
                bukkitVersion.contains("1.19") &&
                bukkitVersion.contains("1.20")
        ) {
            getLogger().warning("This plugin only support Bukkit/CraftBukkit server 1.21 and upper!");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        // Create main folder
        folder = new File("plugins\\", this.getDescription().getName());
        if (!folder.exists()) folder.mkdir();

        this.getCommand("bcash").setExecutor(new Cash());
    }

    public static BCash getInstance() {
        return instance;
    }
}

