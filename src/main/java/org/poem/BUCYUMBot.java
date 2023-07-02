package org.poem;


import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BUCYUMBot extends TelegramLongPollingBot {

    //填你自己的token和username
    private final String token = "5913104395:AAGf5AiCXY649u64YMW5ch40at5OUF4UUWA";
    private final String username = "BUCYUMBot";

    public BUCYUMBot() {
        this(new DefaultBotOptions());
    }

    public BUCYUMBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public String getBotUsername() {
        return this.username;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            Long chatId = message.getChatId();

            String text = message.getText();

            sendMsg("不", chatId);
        }
    }


    //回复普通文本消息
    public void sendMsg(String text, Long chatId) {
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chatId));
        response.setText(text);
        try {
            execute(response);
        } catch (TelegramApiException ignored) {
        }
    }
}

