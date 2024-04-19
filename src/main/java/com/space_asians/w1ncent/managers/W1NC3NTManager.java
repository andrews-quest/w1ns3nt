package com.space_asians.w1ncent.managers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class W1NC3NTManager {

    public SendMessage consume(Message message){
        return SendMessage
                .builder()
                .chatId(message.getChatId())
                .text("Sie benutzen ein allgemeiner W1NC3NTManager anstatt von spezialisiertem Manager. Etwas ist Schiffgegangen.")
                .build();
    }
}