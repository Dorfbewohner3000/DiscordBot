package de.Dorfbewohner3000.DiscordBot;

import de.Dorfbewohner3000.Events.Events;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {

    public static void main(String[] args) throws Throwable {
        JDA jda = new JDABuilder("MzU0NjI1MjIyODQzOTU3MjUy.Dy48qA.6I3FXNbwTei7juPtpMUoeEqtmgc")
                .addEventListeners(new Events())
                .build();
        Help.getready();
    }
}
