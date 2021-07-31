package net.kyaz0x1.dcwebhookexecutor.api;

import com.google.gson.Gson;
import net.kyaz0x1.dcwebhookexecutor.api.except.WebhookErrorException;
import net.kyaz0x1.dcwebhookexecutor.api.models.DiscordError;
import net.kyaz0x1.dcwebhookexecutor.api.service.WebService;

public final class DiscordAPI {

    private static DiscordAPI INSTANCE;

    private final WebService webService;
    private final Gson gson;

    private DiscordAPI(){
        this.webService = WebService.getInstance();
        this.gson = new Gson();
    }

    public boolean executeWebhook(String url, String json) throws WebhookErrorException {
        final String response = webService.post(url, json);

        if(response.isEmpty())
            return true;

        final DiscordError error = gson.fromJson(response, DiscordError.class);
        throw new WebhookErrorException(error.getMessage());
    }

    public static DiscordAPI getInstance(){
        if(INSTANCE == null){
            synchronized(DiscordAPI.class){
                if(INSTANCE == null){
                    INSTANCE = new DiscordAPI();
                }
            }
        }
        return INSTANCE;
    }

}