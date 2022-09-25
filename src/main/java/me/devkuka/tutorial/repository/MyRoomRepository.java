package me.devkuka.tutorial.repository;

import me.devkuka.tutorial.entity.MyRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRoomRepository extends JpaRepository<MyRoom, Long> {
}
