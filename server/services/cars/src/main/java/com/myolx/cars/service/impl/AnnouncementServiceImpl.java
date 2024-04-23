package com.myolx.cars.service.impl;

import com.myolx.cars.controller.request.AddAnnouncementRequest;
import com.myolx.cars.entity.CarAnnouncement;
import com.myolx.cars.entity.CarImage;
import com.myolx.cars.repository.CarAnnouncementRepository;
import com.myolx.cars.service.IAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements IAnnouncementService {
    private final CarAnnouncementRepository carAnnouncementRepository;

    /**
     * @param request - AddAnnouncementRequest object contains info about announcement given by client.
     * @param files   - List of cars photos, *only png/jpg.
     * @throws IOException - Throw exception when file is invalid.
     */
    @Override
    public void addCarAnnouncement(AddAnnouncementRequest request, MultipartFile[] files) throws IOException {
        List<CarImage> carImages = new ArrayList<>();

        for (MultipartFile file : files){
            boolean contentTypeIfFine =
                    Objects.equals(file.getContentType(), "image/jpeg");

            if(contentTypeIfFine){
                carImages.add(
                        new CarImage.Builder()
                                .name(file.getOriginalFilename())
                                .type(file.getContentType())
                                .imageData(file.getBytes())
                                .build());
            }
            else throw new RuntimeException("Given format " + file.getContentType() + " is wrong. Input image/jpeg");
        }
        CarAnnouncement carAnnouncement = new CarAnnouncement.Builder()
                .title(request.getTitle())
                .phoneNumber(request.getPhoneNumber())
                .description(request.getDescription())
                .carImages(carImages)
                .build();

        carAnnouncementRepository.save(carAnnouncement);
    }

    private byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }
}
