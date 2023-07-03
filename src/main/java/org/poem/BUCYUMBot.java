package org.poem;


import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BUCYUMBot extends TelegramLongPollingBot {
    DatagramSocket Socket = new DatagramSocket(2365);
    public BUCYUMBot() throws SocketException {
        this(new DefaultBotOptions());
    }

    public BUCYUMBot(DefaultBotOptions options) throws SocketException {
        super(options);
    }

    @Override
    public String getBotToken() {
        //填你自己的token和username
        return "5913104395:AAGf5AiCXY649u64YMW5ch40at5OUF4UUWA";
    }

    @Override
    public String getBotUsername() {
        return "BUCYUMBot";
    }

    public void sendToSer(String message) throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(),
                message.getBytes().length, InetAddress.getByName("127.0.0.1"), 2366);

        Socket.send(datagramPacket);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                Message message = update.getMessage();
                Long chatId = message.getChatId();
                String text = message.getText();
                String[] ifcmd = text.split(" ");
                if (ifcmd[0].equals("绑定基岩版")){
                    if (ifcmd[1].matches("[A-Za-z0-9_]*")) {
                        sendMsg("绑定成功！",chatId);
                    }
                }
                String formatmessage = "["+message.getFrom().getUserName()+"] " + text;
                sendToSer(formatmessage);
            } catch (IOException ignored) {}
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

