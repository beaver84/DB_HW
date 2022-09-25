package me.devkuka.tutorial.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyRoomResponse {

    private String myRoomName;

    private String landlord;

    private String region;

    private int deposit;

    private int rent;

    @Builder
    public MyRoomResponse(String myRoomName, String landlord, String region, int deposit, int rent) {
        this.myRoomName = myRoomName;
        this.landlord = landlord;
        this.region = region;
        this.deposit = deposit;
        this.rent = rent;
    }
}
