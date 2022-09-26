package me.devkuka.tutorial.service;

import me.devkuka.tutorial.dto.*;

import java.util.List;

public interface MyRoomService {

    List<MyRoomResponse> getAllRooms();

    List<MyRoomResponse> getAllMyRooms(String username);

    MyRoomResponse getMyRoomById(long myRoomId);

    MyRoomResponse addMyRoom(MyRoomRequest myRoomRequest, RoomTypeRequest roomTypeRequest, List<PriceTypeRequest> PriceTypeRequests);

    MyRoomModifyResponse modifyMyRoom(long myRoomId, MyRoomModifyRequest myRoomRequest);

    void deleteMyRoom(long myRoomId);

}
