package dre.dreblocks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event)
    {
        String blockName = event.getItemInHand().getItemMeta().getDisplayName();
        if (getBlock.hasName(blockName)) {
            Block block = event.getBlockPlaced();
            Material mat = Material.valueOf(main.plugin.getConfig().getString(getBlock.getPath(blockName) + ".type"));
            block.setType(mat, false);
            BlockData blockData = block.getBlockData();
            MultipleFacing multiFacing = (MultipleFacing) blockData;
            multiFacing.setFace(BlockFace.UP, main.plugin.getConfig().getBoolean(getBlock.getPath(blockName) + ".facing.up"));
            multiFacing.setFace(BlockFace.DOWN, main.plugin.getConfig().getBoolean(getBlock.getPath(blockName) + ".facing.down"));
            multiFacing.setFace(BlockFace.NORTH, main.plugin.getConfig().getBoolean(getBlock.getPath(blockName) + ".facing.north"));
            multiFacing.setFace(BlockFace.EAST, main.plugin.getConfig().getBoolean(getBlock.getPath(blockName) + ".facing.east"));
            multiFacing.setFace(BlockFace.SOUTH, main.plugin.getConfig().getBoolean(getBlock.getPath(blockName) + ".facing.south"));
            multiFacing.setFace(BlockFace.WEST, main.plugin.getConfig().getBoolean(getBlock.getPath(blockName) + ".facing.west"));
            block.setBlockData(multiFacing);

        }
    //    if (event.getBlockPlaced().getType().equals(Material.RED_MUSHROOM_BLOCK) || (event.getBlockPlaced().getType().equals(Material.BROWN_MUSHROOM_BLOCK))) {
    //        event.getBlockPlaced().
    //}
    }
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onMushroomPhysics(BlockPhysicsEvent event) {
        if ((event.getChangedType() == Material.BROWN_MUSHROOM_BLOCK) || (event.getChangedType() == Material.RED_MUSHROOM_BLOCK)) {
            event.setCancelled(true);
            event.getBlock().getState().update(true, false);
        }
    }
}
