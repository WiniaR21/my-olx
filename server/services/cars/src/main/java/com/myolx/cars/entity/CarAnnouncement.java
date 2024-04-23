package com.myolx.cars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
