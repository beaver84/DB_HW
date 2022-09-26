package me.devkuka.tutorial.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_Id")
    private long roomTypeId;

    @Column(name = "my_room_id")
    private long myRoomId;

    @Column(name = "room_Type_name")
    private String roomTypeName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_room_id", insertable = false, updatable = false)
    private MyRoom myRoom;

    @Builder
    public RoomType(long roomTypeId, long myRoomId, String roomTypeName, MyRoom myRoom) {
        this.roomTypeId = roomTypeId;
        this.myRoomId = myRoomId;
        this.roomTypeName = roomTypeName;
        this.myRoom = myRoom;
    }
}
