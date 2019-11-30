package de.cade.languagesystem.listener;

import de.cade.languagesystem.LanguageSystem;
import de.cade.languagesystem.handler.MessageHandler;
import de.cade.languagesystem.util.Language;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        MessageHandler messageHandler = LanguageSystem.getInstance().getMessageHandler();
        event.setJoinMessage(messageHandler.getMessage("join", Language.ENGLISH.getCache(), event.getPlayer().getName()));
    }

}
