package com.holeiko.database.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "moisture_sensor_work", schema = "holeiko_db", catalog = "")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoistureSensorWork {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "sensor_id")
    private int sensorId;
    @Basic
    @Column(name = "moisture")
    private int moisture;
    @Basic
    @Column(name = "time")
    private Timestamp time;

}
