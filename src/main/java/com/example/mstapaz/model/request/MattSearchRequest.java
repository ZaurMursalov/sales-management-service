package com.example.mstapaz.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MattSearchRequest {
    int priceFrom;
    int priceTo;
    String description;
}
