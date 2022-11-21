package com.holeiko.database.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pump {
    private Integer id;
    private Integer area;
    private Integer count_of_motors;
    private Integer water_consume;


}
