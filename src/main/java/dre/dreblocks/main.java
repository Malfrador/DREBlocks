package dre.dreblocks;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    FileConfiguration config = getConfig();
    public static main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new blockListener(), this);
        this.saveDefaultConfig();
        getLogger().info("Loading custom Blocks...");
        int i = 0;
        getLogger().info("Block:   UP | DOWN  | NORTH | EAST  | SOUTH | WEST | Block Type");
        for(String blockName : config.getConfigurationSection("blocks").getKeys(false)) {
            String blockPath = "blocks." + blockName;
            String name = config.getString(blockPath + ".name");
            Boolean up = config.getBoolean(blockPath + ".facing.up");
            Boolean down = config.getBoolean(blockPath + ".facing.down");
            Boolean north = config.getBoolean(blockPath + ".facing.north");
            Boolean east = config.getBoolean(blockPath + ".facing.east");
            Boolean south = config.getBoolean(blockPath + ".facing.south");
            Boolean west = config.getBoolean(blockPath + ".facing.west");
            Material mat = Material.valueOf(config.getString(blockPath + ".type"));
            getLogger().info("" + name + ": " + up + " | " + down + " | " + north + " | " + east + " | " + south + " | " + west +" | " + mat);
            i+=1;
        }
        getLogger().info(i + " Blocks loaded.");
        if (i < 1) {
            getLogger().info("0 Blocks loaded. If this is your first time using this plugin, restart the server again to fix this.");
        }

    }
    @Override
    public void onDisable() {
        getLogger().info("DREBlocks disabled.");
    }
}

