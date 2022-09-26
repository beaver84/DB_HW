package me.devkuka.tutorial.repository;

import me.devkuka.tutorial.entity.PriceType;
import me.devkuka.tutorial.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceTypeRepository extends JpaRepository<PriceType, Long> {

}
