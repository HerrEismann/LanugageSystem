package de.cade.languagesystem.util;

import lombok.Getter;

@Getter
public class Message {

    private String join, prefix;

    public Message() {
        prefix = "§7[§eLanguageSystem§7]";
        join = "%prefix% §7Der Spieler §e{0} §7hat denn Server beigetreten!";
    }

}
