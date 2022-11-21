package com.holeiko.database.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Area {
    private Integer id;
    private Integer square;
    private Integer ownerClient;
    private Double latitude;
    private Double longitude;

}
