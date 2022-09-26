package me.devkuka.tutorial.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.devkuka.tutorial.entity.MyRoom;

@Getter
@Setter
@NoArgsConstructor
public class PriceTypeResponse {

    private long priceTypeId;

    private long myRoomId;

    private String priceTypeName;

    private MyRoom myRoom;

    @Builder
    public PriceTypeResponse(long priceTypeId, long myRoomId, String priceTypeName, MyRoom myRoom) {
        this.priceTypeId = priceTypeId;
        this.myRoomId = myRoomId;
        this.priceTypeName = priceTypeName;
        this.myRoom = myRoom;
    }
}
