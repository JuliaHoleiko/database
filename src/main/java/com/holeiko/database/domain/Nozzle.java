package com.holeiko.database.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nozzle {
    private Integer id;
    private Integer systemId;
    private Integer maxWaterConsume;
    private Double latitude;
    private Double longitude;
}
