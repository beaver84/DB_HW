package me.devkuka.tutorial.controller;

import lombok.RequiredArgsConstructor;
import me.devkuka.tutorial.dto.*;
import me.devkuka.tutorial.service.MyRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class MyRoomController {

    private final MyRoomService myRoomService;

    @GetMapping("/v1/my-room/all")
    public List<MyRoomResponse> getAllRooms(
    ) {
        return myRoomService.getAllRooms();
    }

    @GetMapping("/v1/my-room/username/{username}")
    public List<MyRoomResponse> getAllMyRooms(
            @PathVariable String username
    ) {
        return myRoomService.getAllMyRooms(username);
    }

    @GetMapping("/v1/my-room/id/{myRoomId}")
    public MyRoomResponse getMyRoomById(
            @PathVariable long myRoomId
    ) {
        return myRoomService.getMyRoomById(myRoomId);
    }

    @PostMapping("/v1/my-room")
    public MyRoomResponse addMyRoom(
            @RequestBody MyRoomRequest myRoomRequest,
            @RequestBody RoomTypeRequest roomTypeRequest,
            @RequestBody List<PriceTypeRequest> PriceTypeRequests
    ) {
        return myRoomService.addMyRoom(myRoomRequest, roomTypeRequest, PriceTypeRequests);
    }

    @PutMapping("/v1/my-room")
    public MyRoomModifyResponse modifyMyRoom(
            @RequestParam long myRoomId,
            @RequestBody MyRoomModifyRequest myRoomModifyRequest
    ) {
        return myRoomService.modifyMyRoom(myRoomId, myRoomModifyRequest);
    }

    @DeleteMapping("/v1/my-room")
    public void deleteMyRoom(
            @RequestParam long myRoomId
    ) {
        myRoomService.deleteMyRoom(myRoomId);
    }
}
