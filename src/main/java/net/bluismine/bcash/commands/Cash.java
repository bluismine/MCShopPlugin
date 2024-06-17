package net.bluismine.bcash.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class Cash implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Cash
        ItemStack Cash_10 = new ItemStack(Material.LIME_DYE);
        ItemStack Cash_50 = new ItemStack(Material.YELLOW_DYE);
        ItemStack Cash_100 = new ItemStack(Material.RED_DYE);

        ItemMeta Cash_10_Meta = Cash_10.getItemMeta();
        ItemMeta Cash_50_Meta = Cash_50.getItemMeta();
        ItemMeta Cash_100_Meta = Cash_100.getItemMeta();

        Cash_10_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&a10$"));
        Cash_10_Meta.setUnbreakable(true);
        Cash_10_Meta.setLore(List.of("",ChatColor.translateAlternateColorCodes('&',"&8Đây là tiền tệ không phải đồ ăn."),""));
        Cash_50_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6⚒ &a50$ &6⚒"));
        Cash_50_Meta.setUnbreakable(true);
        Cash_50_Meta.setLore(List.of("",ChatColor.translateAlternateColorCodes('&',"&8Đây là tiền tệ không phải đồ ăn."),""));
        Cash_100_Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6⛏ &a100$ &6⛏"));
        Cash_100_Meta.setUnbreakable(true);
        Cash_100_Meta.setLore(List.of("",ChatColor.translateAlternateColorCodes('&',"&8Đây là tiền tệ không phải đồ ăn."),""));

        Cash_10.setItemMeta(Cash_10_Meta);
        Cash_50.setItemMeta(Cash_50_Meta);
        Cash_100.setItemMeta(Cash_100_Meta);

        // Commands
        Player player = Bukkit.getPlayer(args[1]);
        if (sender instanceof Player) {
            sender.sendMessage("&4Lệnh này chỉ dành cho máy chủ, người chơi không được phép sử dụng.");
            return false;
        } else {
            if (args[0].equalsIgnoreCase("give")) {
                if (args[1].equalsIgnoreCase(player.getName())) {
                    if (args[2].equalsIgnoreCase("10")) {
                        player.getInventory().addItem(Cash_10);
                    } else if (args[2].equalsIgnoreCase("50")) {
                        player.getInventory().addItem(Cash_50);
                    } else if (args[2].equalsIgnoreCase("100")) {
                        player.getInventory().addItem(Cash_100);
                    } else {
                        sender.sendMessage("Số tiền trên không hợp lệ, vui lòng thử 10$, 50$ hoặc 100$.");
                    }
                } else {
                    System.out.println("Không tìm thấy người chơi");
                    return false;
                }
            } else if (args[0].equalsIgnoreCase("remove")) {
                if (args[1].equalsIgnoreCase(player.getName())) {
                    if (args[2].equalsIgnoreCase("10")) {
                        player.getInventory().removeItem(Cash_10);
                    } else if (args[2].equalsIgnoreCase("50")) {
                        player.getInventory().removeItem(Cash_50);
                    } else if (args[2].equalsIgnoreCase("100")) {
                        player.getInventory().removeItem(Cash_100);
                    } else {
                        sender.sendMessage("Số tiền trên không hợp lệ, vui lòng thử 10$, 50$ hoặc 100$.");
                    }
                } else {
                    System.out.println("Không tìm thấy người chơi");
                    return false;
                }
            } else return false;
        }

        return false;
    }
}
