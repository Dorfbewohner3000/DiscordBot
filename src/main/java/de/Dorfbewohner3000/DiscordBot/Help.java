package de.Dorfbewohner3000.DiscordBot;

import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Help {
    static ArrayList<String> Commands = new ArrayList<>();
    static HashMap<String, String> info = new HashMap<>();
    public static void getready(){
        Commands.add("help");
        info.put("help", "You get a Message with all Bot-Help");
        Commands.add("join");
        info.put("join", "The Bot will join in your channel");
        Commands.add("leave");
        info.put("leave", "The Bot will leave the channel");
    }
    public String HelpMessage(String cmd) {
        String out = "";
        if (cmd == null) {
            for (String cmds : Commands) {
                if (out == "") {
                    out = "```" + "!" + cmds + " - " + info.get(cmds) + "```";
                }else {
                    out = out+"```" +"!"+ cmds +" - "+ info.get(cmds) + "```";
                }
            }
        }else{
            cmd = cmd.toLowerCase();
            if(Commands.contains(cmd)){
                out = out+"```" + cmd + " - "+ info.get(cmd) + "```";
            }else{
                out = "The Command \""+cmd+"\" was not found. Please try again";
            }
        }
        System.out.println("The Message: "+out);
        return out;
    }
    public Help(Event event){
        String msg = ((MessageReceivedEvent) event).getMessage().getContentDisplay();
        if(msg.equalsIgnoreCase("!help")){
            ((MessageReceivedEvent) event).getAuthor().openPrivateChannel().queue((channel) ->
            {
                channel.sendMessage(HelpMessage(null)).queue();
            });
        }else{
            ((MessageReceivedEvent) event).getAuthor().openPrivateChannel().queue((channel) ->
            {
                channel.sendMessage(HelpMessage(msg.split(" ")[1])).queue();
            });
        }
    }
}
