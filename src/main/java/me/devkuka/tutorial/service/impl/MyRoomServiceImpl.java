package me.devkuka.tutorial.service.impl;

import lombok.RequiredArgsConstructor;
import me.devkuka.tutorial.dto.MyRoomResponse;
import me.devkuka.tutorial.entity.MyRoom;
import me.devkuka.tutorial.repository.MyRoomRepository;
import me.devkuka.tutorial.service.MyRoomService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyRoomServiceImpl implements MyRoomService {

    private final MyRoomRepository myRoomRepository;

    @Override
    public List<MyRoomResponse> getAllRooms() {
        List<MyRoom> allRoomList = myRoomRepository.findAll();

        return allRoomList.stream().map(myRoom -> MyRoomResponse.builder()
                .myRoomName(myRoom.getMyRoomName())
                .landlord(myRoom.getLandlord())
                .region(myRoom.getRegion())
                .deposit(myRoom.getDeposit())
                .rent(myRoom.getRent())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<MyRoomResponse> getAllMyRooms(String username) {
        List<MyRoom> myRoomList = myRoomRepository.findAllByLandlord(username);

        return myRoomList.stream().map(myRoom -> MyRoomResponse.builder()
                .myRoomName(myRoom.getMyRoomName())
                .landlord(myRoom.getLandlord())
                .region(myRoom.getRegion())
                .deposit(myRoom.getDeposit())
                .rent(myRoom.getRent())
                .build()).collect(Collectors.toList());
    }
}
