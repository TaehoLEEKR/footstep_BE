package com.example.footstep.domain.repository;

import com.example.footstep.domain.dto.chat.ChatRoomDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoomDto> chatRoomMap;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoomDto> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoomDto findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public ChatRoomDto createChatRoom(String name,Long ShareRoomId) {
        ChatRoomDto chatRoom = ChatRoomDto.create(name,ShareRoomId);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}
