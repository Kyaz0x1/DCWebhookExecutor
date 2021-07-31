package net.kyaz0x1.dcwebhookexecutor.api.webhook.models;

public class EmbedMessage {

    private String title;
    private String description;
    private int color;

    public EmbedMessage(String title, String description, int color){
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getColor() {
        return color;
    }

}