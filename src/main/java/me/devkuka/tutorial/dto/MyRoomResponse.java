package me.devkuka.tutorial.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.devkuka.tutorial.entity.PriceType;
import me.devkuka.tutorial.entity.RoomType;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyRoomResponse {

    private String myRoomName;

    private String landlord;

    private String region;

    private int deposit;

    private int rent;

    private List<PriceType> priceTypes = new ArrayList<>();

    private RoomType roomType;

    @Builder
    public MyRoomResponse(String myRoomName, String landlord, String region, int deposit, int rent, List<PriceType> priceTypes, RoomType roomType) {
        this.myRoomName = myRoomName;
        this.landlord = landlord;
        this.region = region;
        this.deposit = deposit;
        this.rent = rent;
        this.priceTypes = priceTypes;
        this.roomType = roomType;
    }
}
