package com.gmail.festercube;


import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminMode extends JavaPlugin
{
	public static ArrayList<String> adminModePlayers =  new ArrayList<String>();
	public void onEnable()
	{
		getLogger().info("AdminMode plugin has been enabled!");
	}
 
	public void onDisable()
	{
		getLogger().info("AdminMode has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		if (sender instanceof Player) 
		{
			player = (Player) sender;
		}
	 
		if (cmd.getName().equalsIgnoreCase("adminmodeon"))
		{
			if (player != null)
			{
				String name = player.getPlayerListName();
				if (adminModePlayers.contains(name))
				{
					player.sendMessage("You are already in AdminMode! Say /adminmodeooff to exit AdminMode");
				}
				else
				{
					adminModePlayers.add(name);
				}
			}
			
				
		}
		
		else if (cmd.getName().equalsIgnoreCase("adminmodeoff"))
		{
			if (player != null)
			{
				String name = player.getPlayerListName();
				if (adminModePlayers.contains(name))
				{
					player.sendMessage("You are already out of AdminMode! Say /adminmodeon to enter AdminMode");
				}
				else
				{
					adminModePlayers.remove(name);
				}
			}
		}
		
		return false;
	}
	
}
