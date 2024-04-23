package com.myolx.cars.repository;

import com.myolx.cars.entity.CarAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarAnnouncementRepository extends JpaRepository<CarAnnouncement, Long> {
}
