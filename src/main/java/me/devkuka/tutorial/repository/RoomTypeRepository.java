package me.devkuka.tutorial.repository;

import me.devkuka.tutorial.entity.MyRoom;
import me.devkuka.tutorial.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
