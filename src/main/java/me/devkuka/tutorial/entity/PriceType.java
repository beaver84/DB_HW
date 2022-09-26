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
@NoArgsConstructor
@Entity
@Table(name = "price_type")
public class PriceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_type_Id")
    private long priceTypeId;

    @Column(name = "my_room_id")
    private long myRoomId;

    @Column(name = "price_Type_name")
    private String priceTypeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_room_id", insertable = false, updatable = false)
    private MyRoom myRoom;

    @Builder
    public PriceType(long priceTypeId, long myRoomId, String priceTypeName, MyRoom myRoom) {
        this.priceTypeId = priceTypeId;
        this.myRoomId = myRoomId;
        this.priceTypeName = priceTypeName;
        this.myRoom = myRoom;
    }
}
