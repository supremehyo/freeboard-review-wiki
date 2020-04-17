package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.Chat.ChatRoom;

@Component
public class ChatRoomRepository {

	private LinkedHashMap<String, ChatRoom> chatRoomMap;
	 
    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<String, ChatRoom>();
    }
 
    public List<ChatRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }
 
    public ChatRoom findRoomById(String id) {
        return chatRoomMap.get(id);
    }
 
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}
