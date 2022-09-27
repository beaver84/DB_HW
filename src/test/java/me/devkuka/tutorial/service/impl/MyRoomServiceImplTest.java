package me.devkuka.tutorial.service.impl;

import me.devkuka.tutorial.dto.MyRoomResponse;
import me.devkuka.tutorial.entity.MyRoom;
import me.devkuka.tutorial.repository.MyRoomRepository;
import me.devkuka.tutorial.repository.PriceTypeRepository;
import me.devkuka.tutorial.repository.RoomTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class MyRoomServiceImplTest {

    @Autowired
    MyRoomServiceImpl myRoomServiceImpl;

    @Autowired
    MyRoomRepository myRoomRepository;

    @Autowired
    PriceTypeRepository priceTypeRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    MyRoom myRoom;

    @BeforeEach
    void setUp() {
        myRoom = new MyRoom();
        myRoom.setMyRoomId(1L);
        myRoom.setMyRoomName("나의방1");
        myRoom.setLandlord("배경태");
        myRoom.setRegion("서울");
        myRoom.setDeposit(500);
        myRoom.setRent(100);
        myRoomRepository.save(myRoom);

        myRoom = new MyRoom();
        myRoom.setMyRoomId(2L);
        myRoom.setMyRoomName("나의방2");
        myRoom.setLandlord("배이든");
        myRoom.setRegion("부산");
        myRoom.setDeposit(1500);
        myRoom.setRent(1000);
        myRoomRepository.save(myRoom);
    }

    @Test
    @DisplayName("모든 마이룸을 정상적으로 조회한다.")
    void findAllMyRooms() {
        //given

        //when
        List<MyRoomResponse> allRooms = myRoomServiceImpl.getAllRooms();

        //then
        assertThat(allRooms).size().isGreaterThanOrEqualTo(1);
        assertThat(allRooms).extracting(MyRoomResponse::getMyRoomName).containsExactly("나의방1", "나의방2");
        assertThat(allRooms).extracting(MyRoomResponse::getRegion).containsExactly("서울", "부산");
        assertThat(allRooms).extracting(MyRoomResponse::getLandlord).containsExactly("배경태", "배이든");
        assertThat(allRooms).extracting(MyRoomResponse::getDeposit).containsExactly(500, 1500);
        assertThat(allRooms).extracting(MyRoomResponse::getRent).containsExactly(100, 1000);
    }

    @Test
    @DisplayName("내 마이룸을 정상적으로 조회한다.")
    void findMyRoom() {
        //given

        //when
        List<MyRoomResponse> allRooms = myRoomServiceImpl.getAllMyRooms("배경태");

        //then
        assertThat(allRooms).size().isGreaterThanOrEqualTo(1);
        assertThat(allRooms).extracting(MyRoomResponse::getMyRoomName).containsExactly("나의방1");
        assertThat(allRooms).extracting(MyRoomResponse::getRegion).containsExactly("서울");
        assertThat(allRooms).extracting(MyRoomResponse::getLandlord).containsExactly("배경태");
        assertThat(allRooms).extracting(MyRoomResponse::getDeposit).containsExactly(500);
        assertThat(allRooms).extracting(MyRoomResponse::getRent).containsExactly(100);
    }
}