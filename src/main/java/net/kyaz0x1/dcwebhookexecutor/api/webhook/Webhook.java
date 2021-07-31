package net.kyaz0x1.dcwebhookexecutor.api.webhook;

import net.kyaz0x1.dcwebhookexecutor.api.webhook.models.EmbedMessage;

import java.util.Arrays;
import java.util.List;

public class Webhook {

    private String content;
    private String username;
    private boolean tts;

    private List<EmbedMessage> embeds;

    public Webhook(String content, String username, boolean tts, List<EmbedMessage> embeds){
        this.content = content;
        this.username = username;
        this.tts = tts;
        this.embeds = embeds;
    }

    public Webhook(String content, String username, boolean tts, EmbedMessage ... embeds){
        this(content, username, tts, Arrays.asList(embeds));
    }

}