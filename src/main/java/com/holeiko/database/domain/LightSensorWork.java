package com.holeiko.database.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "light_sensor_work", schema = "holeiko_db", catalog = "")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LightSensorWork {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "sensor_id")
    private int sensorId;
    @Basic
    @Column(name = "light")
    private int light;
    @Basic
    @Column(name = "time")
    private Timestamp time;

}
