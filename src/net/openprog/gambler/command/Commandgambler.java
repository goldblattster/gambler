package net.openprog.gambler.command;

import net.openprog.gambler.Gambler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandgambler implements CommandExecutor {
	private Gambler plugin;
	public Commandgambler(Gambler plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gambler")) {
			Player player = null;
			
			if (sender instanceof Player) {
				player = (Player) sender;
			}
			
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(Gambler.chatPrefix + "Gambler available commands:");
					sender.sendMessage(ChatColor.GRAY + "    - /gambler help - View this help menu.");
					sender.sendMessage(ChatColor.GRAY + "    - /gamble <amount> - Bet an amount for a chance to recieve double the amount back!");
					
					if (player == null) {
						sender.sendMessage(ChatColor.GRAY + "    - /gambler reload - Reload the gambler configuration.");
					} else if (player.hasPermission("gambler.admin")) {
						sender.sendMessage(ChatColor.GRAY + "    - /gambler reload - Reload the gambler configuration.");
					}
				}
				
				if (args[0].equalsIgnoreCase("reload")) {
					if (player == null) {
						plugin.reloadConfig();
						sender.sendMessage(Gambler.chatPrefix + "Plugin reloaded successfully.");
					} else if (player.hasPermission("gambler.admin")) {
						plugin.reloadConfig();
						sender.sendMessage(Gambler.chatPrefix + "Plugin reloaded successfully.");
					}
				}
			} else {
				sender.sendMessage(Gambler.chatPrefix + "Gambler version " + plugin.getDescription().getVersion() + ".");
				sender.sendMessage(Gambler.chatPrefix + "Type /gambler help for assistance.");
			}
		}
		return true;
	}

}
