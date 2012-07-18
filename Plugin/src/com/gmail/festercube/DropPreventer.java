package com.gmail.festercube;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropPreventer implements Listener 
{
	@EventHandler
	public void onDropAttempt (PlayerDropItemEvent event)
	{
		if(AdminMode.adminModePlayers.contains(event.getPlayer().getPlayerListName()))
		{
			event.setCancelled(true);
		}
	}

}
