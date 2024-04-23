package com.myolx.cars.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CarAnnouncement {
    @Id
    private Long carAnnouncementId;

    /**
     * PhoneNumber of account
     */
    @Column(name = "belongs_to")
    private String belongsTo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carAnnouncement")
    private List<CarImage> carImages;

    private String description;

}
