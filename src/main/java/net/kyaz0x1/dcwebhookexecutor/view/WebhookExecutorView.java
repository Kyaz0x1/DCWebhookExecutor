package net.kyaz0x1.dcwebhookexecutor.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.kyaz0x1.dcwebhookexecutor.api.webhook.Webhook;
import net.kyaz0x1.dcwebhookexecutor.api.webhook.models.EmbedMessage;
import net.kyaz0x1.dcwebhookexecutor.events.ButtonEnterClickEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WebhookExecutorView extends JFrame {

    private final JLabel lblEnterWebhookUrl;

    private final JTextField txtWebhookUrl;
    private final JTextArea taContent;

    private final JButton btnExecute;

    public WebhookExecutorView(){
        super("DCWebhookExecutor v1.0.0");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        this.lblEnterWebhookUrl = new JLabel("Informe a url do webhook:");
        lblEnterWebhookUrl.setBounds(170, 5, 150, 20);

        add(lblEnterWebhookUrl);

        this.txtWebhookUrl = new JTextField();
        txtWebhookUrl.setBounds(10, 25, 465, 20);

        add(txtWebhookUrl);

        this.taContent = new JTextArea();
        taContent.setBounds(10, 50, 465, 280);

        final EmbedMessage embedMessage = new EmbedMessage("Test", "Test description", Integer.parseInt("3498db", 16));
        final Webhook webhook = new Webhook("Test content", "Test", false, embedMessage);

        final Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        taContent.setText(gson.toJson(webhook));

        add(taContent);

        this.btnExecute = new JButton("Executar");
        btnExecute.setBounds(10, 335, 465, 20);
        btnExecute.addActionListener(new ButtonEnterClickEvent(txtWebhookUrl, taContent));

        add(btnExecute);
    }

}