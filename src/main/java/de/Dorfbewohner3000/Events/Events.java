package de.Dorfbewohner3000.Events;

import de.Dorfbewohner3000.DiscordBot.Help;
import de.Dorfbewohner3000.DiscordBot.Join;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class Events implements EventListener {
    @Override
    public void onEvent(Event event)
    {
        if (event instanceof MessageReceivedEvent){
            if (((MessageReceivedEvent) event).getAuthor().isBot()) return;
            String msg = ((MessageReceivedEvent) event).getMessage().getContentDisplay();
            if(msg.startsWith("!")){
                if(msg.startsWith("!help")){
                    new Help(event);
                }
                if(msg.startsWith("!join")){
                    new Join(((MessageReceivedEvent) event).getTextChannel(), ((MessageReceivedEvent) event).getMember());
                }
                if(msg.startsWith("!disconnect") || msg.startsWith("!leave")){
                    ((MessageReceivedEvent) event).getGuild().getAudioManager().closeAudioConnection();
                }
            }
        }

    }
}
