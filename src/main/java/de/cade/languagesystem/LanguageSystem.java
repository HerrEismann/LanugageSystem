package de.cade.languagesystem;

import de.cade.languagesystem.handler.MessageHandler;
import de.cade.languagesystem.listener.Join;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class LanguageSystem extends JavaPlugin {

    @Getter
    private static LanguageSystem instance;
    private MessageHandler messageHandler;

    @Override
    public void onEnable() {

        instance = this;
        messageHandler = new MessageHandler(this);
        getServer().getPluginManager().registerEvents(new Join(), this);

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
