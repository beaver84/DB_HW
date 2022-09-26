package me.devkuka.tutorial.service;

import me.devkuka.tutorial.dto.MyRoomResponse;

import java.util.List;

public interface MyRoomService {

    List<MyRoomResponse> getAllRooms();

    List<MyRoomResponse> getAllMyRooms(String username);
}
