package me.devkuka.tutorial.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "my_room")
public class MyRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_room_id")
    private long myRoomId;

    @Column(name = "my_room_name")
    private String myRoomName;

    @Column(name = "landlord")
    private String landlord;

    @Column(name = "region")
    private String region;

    @Column(name = "deposit")
    private int deposit;

    @Column(name = "rent")
    private int rent;

    @OneToMany(mappedBy = "priceTypeId")
    private List<PriceType> priceTypes = new ArrayList<>();

    @OneToOne(mappedBy = "myRoom")
    private RoomType roomType;

    @Builder
    public MyRoom(long myRoomId, String myRoomName, String landlord, String region, int deposit, int rent, List<PriceType> priceTypes, RoomType roomType) {
        this.myRoomId = myRoomId;
        this.myRoomName = myRoomName;
        this.landlord = landlord;
        this.region = region;
        this.deposit = deposit;
        this.rent = rent;
        this.priceTypes = priceTypes;
        this.roomType = roomType;
    }
}
