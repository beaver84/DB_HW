package me.devkuka.tutorial.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyRoomModifyRequest {

    private long myRoomId;

    private String myRoomName;

    private String landlord;

    private String region;

    private int deposit;

    private int rent;

    @Builder
    public MyRoomModifyRequest(long myRoomId, String myRoomName, String landlord, String region, int deposit, int rent) {
        this.myRoomId = myRoomId;
        this.myRoomName = myRoomName;
        this.landlord = landlord;
        this.region = region;
        this.deposit = deposit;
        this.rent = rent;
    }
}
