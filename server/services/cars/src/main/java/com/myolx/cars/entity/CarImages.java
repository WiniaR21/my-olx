package com.myolx.cars.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
public class CarImages {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long imageId;

    private String name;

    private String type;

    private byte[] imageData;
}
