package me.devkuka.tutorial.repository;

import me.devkuka.tutorial.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    RoomType findByMyRoomId(long myRoomId);
}
