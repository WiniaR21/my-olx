package com.myolx.cars.service.impl;

import com.myolx.cars.controller.request.AddAnnouncementRequest;
import com.myolx.cars.service.IAnnouncementService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    /**
     * @param request - AddAnnouncementRequest object contains info about announcement given by client.
     * @param files   - List of cars photos, *only png/jpg.
     * @throws IOException - Throw exception when file is invalid.
     */
    @Override
    public void addAnnouncement(AddAnnouncementRequest request, MultipartFile[] files) throws IOException {

    }
}
