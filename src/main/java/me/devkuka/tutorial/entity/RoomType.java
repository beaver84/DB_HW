package me.devkuka.tutorial.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
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
    private String roomType_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_room_id", insertable = false, updatable = false)
    private MyRoom myRoom;

    @Builder
    public RoomType(long roomTypeId, long myRoomId, String roomType_name, MyRoom myRoom) {
        this.roomTypeId = roomTypeId;
        this.myRoomId = myRoomId;
        this.roomType_name = roomType_name;
        this.myRoom = myRoom;
    }
}
