package com.myolx.cars.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AddAnnouncementRequest {
    private String phoneNumber;
    private String title;
    private String description;
}
