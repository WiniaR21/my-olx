package com.myolx.cars.repository;

import com.myolx.cars.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarImagesRepository extends JpaRepository<CarImage, Long> {
    Optional<CarImage> findByName(String name);
}
