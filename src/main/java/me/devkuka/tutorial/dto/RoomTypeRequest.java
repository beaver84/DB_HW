package me.devkuka.tutorial.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.devkuka.tutorial.entity.MyRoom;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class RoomTypeRequest {

    private long roomTypeId;

    private long myRoomId;

    private String roomTypeName;

    private MyRoom myRoom;

    @Builder
    public RoomTypeRequest(long roomTypeId, long myRoomId, String roomTypeName, MyRoom myRoom) {
        this.roomTypeId = roomTypeId;
        this.myRoomId = myRoomId;
        this.roomTypeName = roomTypeName;
        this.myRoom = myRoom;
    }
}
