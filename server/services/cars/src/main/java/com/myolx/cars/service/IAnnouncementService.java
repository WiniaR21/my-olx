package com.myolx.cars.service;

import com.myolx.cars.controller.request.AddAnnouncementRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IAnnouncementService {
    /**
     *
     * @param request - AddAnnouncementRequest object contains info about announcement given by client.
     * @param files - List of cars photos, *only png/jpg.
     * @throws IOException - Throw exception when file is invalid.
     */
    void addAnnouncement(AddAnnouncementRequest request, MultipartFile[] files) throws IOException;
}
