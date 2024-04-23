package com.myolx.cars.service;

import com.myolx.cars.entity.CarImage;
import com.myolx.cars.repository.CarImagesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@RequiredArgsConstructor
public class ImagesService {
    private final CarImagesRepository carImagesRepository;

    @Transactional
    public void uploadImage(MultipartFile file) throws IOException {
        CarImage carImage = CarImage.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(compressImage(file.getBytes()))
                .build();

        if (carImage != null){
            carImagesRepository.save(carImage);
        }
    }
    @Transactional
    public byte[] downloadImage(String fileName){
        Optional<CarImage> carImage = carImagesRepository.findByName(fileName);

        if (carImage.isEmpty()){
            throw new RuntimeException("Image not found");
        }
        else {
            return decompressImage(carImage.get().getImageData());
        }
    }
    private byte[] compressImage(byte[] data){
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
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
