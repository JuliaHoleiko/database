package com.holeiko.database.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sensor {
    private int sensor_id;
    private int areas_id;
    private Double latitude;
    private Double longitude;
}
