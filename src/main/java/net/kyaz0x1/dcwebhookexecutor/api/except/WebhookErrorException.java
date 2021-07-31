package net.kyaz0x1.dcwebhookexecutor.api.except;

public class WebhookErrorException extends Exception {

    public WebhookErrorException(String message){
        super(message);
    }

}