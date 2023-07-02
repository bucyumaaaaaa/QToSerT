package org.poem;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        DefaultBotSession defaultBotSession = new DefaultBotSession();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(defaultBotSession.getClass());
            BUCYUMBot bot2 = new BUCYUMBot();
            telegramBotsApi.registerBot(bot2);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}