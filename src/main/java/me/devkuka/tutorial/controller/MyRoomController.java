package me.devkuka.tutorial.controller;

import lombok.RequiredArgsConstructor;
import me.devkuka.tutorial.dto.MyRoomResponse;
import me.devkuka.tutorial.service.MyRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class MyRoomController {

    private final MyRoomService myRoomService;

    @GetMapping("/v1/my-room/all")
    public List<MyRoomResponse> getAllRooms(
    ){
        return myRoomService.getAllRooms();
    }

    @GetMapping("/v1/my-room/{username}")
    public List<MyRoomResponse> getAllMyRooms(
        @PathVariable String username
    ){
        return myRoomService.getAllMyRooms(username);
    }
}
