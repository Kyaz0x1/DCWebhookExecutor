package net.kyaz0x1.dcwebhookexecutor.events;

import net.kyaz0x1.dcwebhookexecutor.api.DiscordAPI;
import net.kyaz0x1.dcwebhookexecutor.api.except.WebhookErrorException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEnterClickEvent implements ActionListener {

    private final JTextField txtWebhookurl;
    private final JTextArea taContent;

    private final DiscordAPI api;

    public ButtonEnterClickEvent(JTextField txtWebhookUrl, JTextArea taContent){
        this.txtWebhookurl = txtWebhookUrl;
        this.taContent = taContent;

        this.api = DiscordAPI.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String url = txtWebhookurl.getText();

        if(url.isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira a url do webhook!", "DCWebhookExecutor", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!url.startsWith("https://discord.com/api/webhooks/") && !url.startsWith("https://canary.discord.com/api/webhooks/")){
            JOptionPane.showMessageDialog(null, "A url informada é inválida!", "DCWebhookExecutor", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final String json = taContent.getText();

        if(json.isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o json para enviar o webhook!", "DCWebhookExecutor", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            api.executeWebhook(url, taContent.getText());
            JOptionPane.showMessageDialog(null, "Webhook enviado com sucesso!");
        }catch(WebhookErrorException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar o webhook! Erro: " + ex.getMessage(), "DCWebhookExecutor", JOptionPane.ERROR_MESSAGE);
        }
    }

}