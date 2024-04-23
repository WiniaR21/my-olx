package com.myolx.cars.repository;

import com.myolx.cars.entity.CarAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementReporisory extends JpaRepository<CarAnnouncement, Long> {
}
