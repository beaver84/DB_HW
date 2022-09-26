package me.devkuka.tutorial.repository;

import me.devkuka.tutorial.entity.MyRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyRoomRepository extends JpaRepository<MyRoom, Long> {

    List<MyRoom> findAllByLandlord(String username);

}
