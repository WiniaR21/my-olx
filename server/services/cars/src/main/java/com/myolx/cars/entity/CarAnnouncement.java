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

    public CarAnnouncement(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.carImages = builder.carImages;
        this.title = builder.title;
        this.description = builder.description;
    }

    public static class Builder{
        private String phoneNumber;
        private List<CarImage> carImages;
        private String title;
        private String description;

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder carImages(List<CarImage> carImages){
            this.carImages = carImages;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public CarAnnouncement build(){return new CarAnnouncement(this);}
    }
}
