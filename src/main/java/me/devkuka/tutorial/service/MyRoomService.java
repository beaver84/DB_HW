package me.devkuka.tutorial.service;

import me.devkuka.tutorial.dto.MyRoomModifyRequest;
import me.devkuka.tutorial.dto.MyRoomModifyResponse;
import me.devkuka.tutorial.dto.MyRoomRequest;
import me.devkuka.tutorial.dto.MyRoomResponse;

import java.util.List;

public interface MyRoomService {

    List<MyRoomResponse> getAllRooms();

    List<MyRoomResponse> getAllMyRooms(String username);

    MyRoomResponse getMyRoomById(long myRoomId);

    MyRoomResponse addMyRoom(MyRoomRequest myRoomRequest);

    MyRoomModifyResponse modifyMyRoom(long myRoomId, MyRoomModifyRequest myRoomRequest);

    void deleteMyRoom(long myRoomId);
}
