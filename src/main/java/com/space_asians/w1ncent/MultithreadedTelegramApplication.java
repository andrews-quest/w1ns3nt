package com.space_asians.w1ncent;

import com.space_asians.w1ncent.bots.W1nc3ntBot;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class MultithreadedTelegramApplication extends Thread {

    private String token;
    private W1nc3ntBot bot;

    public MultithreadedTelegramApplication(String token, W1nc3ntBot bot) {
        this.token = token;
        this.bot = bot;
    }

    @Override
    public void run() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(this.token, this.bot);
            System.out.println("Success");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Failure");
    }
}
