package net.kyaz0x1.dcwebhookexecutor;

import net.kyaz0x1.dcwebhookexecutor.view.WebhookExecutorView;

import javax.swing.SwingUtilities;

public class DCWebhookExecutor {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new WebhookExecutorView().setVisible(true));
    }

}