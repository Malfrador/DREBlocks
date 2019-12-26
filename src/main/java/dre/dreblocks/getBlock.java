package dre.dreblocks;

import org.bukkit.configuration.Configuration;

public class getBlock {
    public static boolean hasName(String name) {
        Configuration config = main.plugin.getConfig();
        int i = 0;
        for(String blockName : config.getConfigurationSection("blocks").getKeys(false)) {
            if (name.equals(config.getString("blocks." + blockName + ".name"))) {
                i++;
            }
        }
        if (i >= 1) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String getPath(String name) {
        Configuration config = main.plugin.getConfig();
        String path = " ";
        for(String blockName : config.getConfigurationSection("blocks").getKeys(false)) {
            if (name.equals(config.getString("blocks." + blockName + ".name"))) {
                path = "blocks." + blockName;
            }
        }
        return path;
    }
}
