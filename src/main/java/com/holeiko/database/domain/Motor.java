package com.holeiko.database.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Motor {
    private Integer id;
    private Integer pumps_id;
}
