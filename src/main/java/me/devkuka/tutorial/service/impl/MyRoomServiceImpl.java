package me.devkuka.tutorial.service.impl;

import lombok.RequiredArgsConstructor;
import me.devkuka.tutorial.dto.*;
import me.devkuka.tutorial.entity.MyRoom;
import me.devkuka.tutorial.entity.PriceType;
import me.devkuka.tutorial.entity.RoomType;
import me.devkuka.tutorial.repository.MyRoomRepository;
import me.devkuka.tutorial.repository.PriceTypeRepository;
import me.devkuka.tutorial.repository.RoomTypeRepository;
import me.devkuka.tutorial.service.MyRoomService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyRoomServiceImpl implements MyRoomService {

    private final MyRoomRepository myRoomRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final PriceTypeRepository priceTypeRepository;

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

    @Override
    public MyRoomResponse getMyRoomById(long myRoomId) {
        MyRoom myRoom = myRoomRepository.findById(myRoomId).orElseThrow(EntityNotFoundException::new);

        return MyRoomResponse.builder()
                .myRoomName(myRoom.getMyRoomName())
                .landlord(myRoom.getLandlord())
                .region(myRoom.getRegion())
                .deposit(myRoom.getDeposit())
                .rent(myRoom.getRent())
                .build();
    }

    @Override
    public MyRoomResponse addMyRoom(MyRoomRequest myRoomRequest, RoomTypeRequest roomTypeRequest,List<PriceTypeRequest> PriceTypeRequests) {

        MyRoom myRoomRequestToEntity = MyRoom.builder()
                .myRoomName(myRoomRequest.getMyRoomName())
                .landlord(myRoomRequest.getLandlord())
                .region(myRoomRequest.getRegion())
                .deposit(myRoomRequest.getDeposit())
                .rent(myRoomRequest.getRent())
                .build();

        MyRoom saveResult = myRoomRepository.save(myRoomRequestToEntity);

        RoomType roomTypeRequestToEntity = RoomType.builder()
                .myRoomId(saveResult.getMyRoomId())
                .roomTypeName(roomTypeRequest.getRoomTypeName())
                .build();

        RoomType roomTypeSaveResult = roomTypeRepository.save(roomTypeRequestToEntity);

        List<PriceType> priceTypeResult = new ArrayList<>();
        for (PriceTypeRequest priceTypeRequest : PriceTypeRequests) {
            PriceType priceTypeRequestToEntity = PriceType.builder()
                    .myRoomId(saveResult.getMyRoomId())
                    .priceTypeName(priceTypeRequest.getPriceTypeName())
                    .build();
            priceTypeRepository.save(priceTypeRequestToEntity);
            priceTypeResult.add(priceTypeRequestToEntity);
        }

        return MyRoomResponse.builder()
                .myRoomName(saveResult.getMyRoomName())
                .landlord(saveResult.getLandlord())
                .region(saveResult.getRegion())
                .deposit(saveResult.getDeposit())
                .rent(saveResult.getRent())
                .roomType(roomTypeSaveResult)
                .priceTypes(priceTypeResult)
                .build();
    }

    @Override
    public MyRoomModifyResponse modifyMyRoom(long myRoomId, MyRoomModifyRequest myRoomModifyRequest) {
        MyRoom myRoomModifyRequestToEntity = MyRoom.builder()
                .myRoomId(myRoomModifyRequest.getMyRoomId())
                .myRoomName(myRoomModifyRequest.getMyRoomName())
                .landlord(myRoomModifyRequest.getLandlord())
                .region(myRoomModifyRequest.getRegion())
                .deposit(myRoomModifyRequest.getDeposit())
                .rent(myRoomModifyRequest.getRent())
                .build();

        MyRoom modifyResult = myRoomRepository.save(myRoomModifyRequestToEntity);

        return MyRoomModifyResponse.builder()
                .myRoomId(modifyResult.getMyRoomId())
                .myRoomName(modifyResult.getMyRoomName())
                .landlord(modifyResult.getLandlord())
                .region(modifyResult.getRegion())
                .deposit(modifyResult.getDeposit())
                .rent(modifyResult.getRent())
                .build();
    }

    @Override
    public void deleteMyRoom(long myRoomId) {
        MyRoom myRoom = myRoomRepository.findById(myRoomId).orElseThrow(EntityNotFoundException::new);
        myRoomRepository.deleteById(myRoom.getMyRoomId());
    }
}
