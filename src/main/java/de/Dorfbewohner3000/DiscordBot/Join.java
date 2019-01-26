package de.Dorfbewohner3000.DiscordBot;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

public class Join {
    public Join(TextChannel textChannel, Member member){
        AudioManager audioManager = textChannel.getGuild().getAudioManager();
        first:
        for(VoiceChannel voiceChannel:textChannel.getGuild().getVoiceChannels()){
            for(Member memberino:voiceChannel.getMembers()){
                if(member == memberino){
                    audioManager.openAudioConnection(voiceChannel);
                    break first;
                }
            }
        }
    }
}
