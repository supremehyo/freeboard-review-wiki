package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.Chat.ChatMessage;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class ChatController {
 
	@Autowired
    private SimpMessagingTemplate messagingTemplate;
 
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
    	if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender() + "¥‘¿Ã ¿‘¿Â«œºÃΩ¿¥œ¥Ÿ.");
    	}
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}