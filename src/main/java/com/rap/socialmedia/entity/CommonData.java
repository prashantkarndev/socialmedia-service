package com.rap.socialmedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonData {

    private LocalTime createdDate;
    private LocalTime updatedDate;
}
