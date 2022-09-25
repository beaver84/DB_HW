package me.devkuka.tutorial.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "roomTypeId")
    private List<RoomType> roomTypes = new ArrayList<>();

    @Builder
    public MyRoom(long myRoomId, String myRoomName, String landlord, String region, int deposit, int rent, List<PriceType> priceTypes, List<RoomType> roomTypes) {
        this.myRoomId = myRoomId;
        this.myRoomName = myRoomName;
        this.landlord = landlord;
        this.region = region;
        this.deposit = deposit;
        this.rent = rent;
        this.priceTypes = priceTypes;
        this.roomTypes = roomTypes;
    }
}
