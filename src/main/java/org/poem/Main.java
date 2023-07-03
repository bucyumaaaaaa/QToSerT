package org.poem;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        try {
            DefaultBotOptions botOptions = new DefaultBotOptions();
            botOptions.setProxyHost("127.0.0.1");
            botOptions.setProxyPort(10810);
            botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

            DefaultBotSession defaultBotSession = new DefaultBotSession();
            defaultBotSession.setOptions(botOptions);

            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(defaultBotSession.getClass());
            BUCYUMBot bot2 = new BUCYUMBot(botOptions);
            telegramBotsApi.registerBot(bot2);
        } catch (TelegramApiException | SocketException e) {
            e.printStackTrace();
        }
    }
}