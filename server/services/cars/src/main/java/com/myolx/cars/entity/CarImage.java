package com.myolx.cars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long imageId;

    private String name;
    private String type;

    @Lob
    @Column(name = "image_data")
    private byte[] imageData;

    @ManyToOne()
    @JoinColumn(name = "announcement_id")
    private CarAnnouncement carAnnouncement;

    public CarImage(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.imageData = builder.imageData;
    }

    public static class Builder{
        private String name;
        private String type;
        private byte[] imageData;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder type(String type){
            this.type = type;
            return this;
        }

        /**
         * Method is compressing data before setting up
         * @param imageData - Image bytes from MultipartFile
         */
        public Builder imageData(byte[] imageData){
            Deflater deflater = new Deflater();
            deflater.setLevel(Deflater.BEST_COMPRESSION);
            deflater.setInput(imageData);
            deflater.finish();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageData.length);
            byte[] tmp = new byte[4*1024];
            while (!deflater.finished()) {
                int size = deflater.deflate(tmp);
                outputStream.write(tmp, 0, size);
            }
            try {
                outputStream.close();
            } catch (Exception ignored) {
            }

            this.imageData = outputStream.toByteArray();
            return this;
        }
        public CarImage build(){return new CarImage(this);}
    }

}
