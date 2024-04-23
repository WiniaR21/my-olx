package com.myolx.cars.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "car_announcement")
@NoArgsConstructor
public class CarAnnouncement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carAnnouncementId;

    /**
     * PhoneNumber of account
     */
    @Column(name = "phone_number", nullable = false, updatable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carAnnouncement")
    private List<CarImage> carImages;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
