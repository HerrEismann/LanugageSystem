package de.cade.languagesystem.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.cade.languagesystem.util.Language;
import de.cade.languagesystem.util.Message;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.HashMap;

public class MessageHandler {

    private Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().disableHtmlEscaping().create();

    public MessageHandler(Plugin plugin) {

        try {
            loadingLanguages(plugin);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadingLanguages(Plugin plugin) throws Exception {

        File folder = new File("plugins//" + plugin.getName() + "//language");
        folder.mkdirs();

        for (Language language : Language.values())
            fileWriter(new File(folder.getPath() + "//" + language.name().toLowerCase()), language);

    }

    private void fileWriter(File file, Language language) throws Exception {

        if (file.exists()) {

            if (gson.fromJson(new FileReader(file), Message.class) != null) {

                Message message = gson.fromJson(new FileReader(file), Message.class);
                HashMap<String, String> cache = language.getCache();
                cache.put("join", message.getJoin());
                cache.put("prefix", message.getPrefix());
                return;

            }

        }

        if (!file.exists())
            file.createNewFile();

        FileWriter writer = new FileWriter(file);
        writer.write(gson.toJson(new Message()));
        writer.flush();
        writer.close();

    }

    public String getMessage(String name, HashMap<String, String> cache, Object... objects) {
        return MessageFormat.format(cache.get(name).replace("%prefix%", cache.get("prefix").replace("&", "§")).replace("&", "§"), objects);
    }

}
